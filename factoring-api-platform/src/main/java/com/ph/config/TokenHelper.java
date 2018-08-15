package com.ph.config;

import org.apache.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * TokenHelper
 * @author YUEYUE
 * 
 */
public class TokenHelper
{
    
    /**
     * 持有token名称的字段名
     */
    public static final String TOKEN_NAME_FIELD = "token";
    private static final Logger LOG = Logger.getLogger(TokenHelper.class);
    private static final Random RANDOM = new Random();

    /**
     *  缓存调用
      */
    private static RedisTemplate  redisTemplate;
    
    
    /**
     * 使用随机字串作为token名字  不需要将token保存到缓存中
     * 调用
     * @param request
     * @return token
     */
    public static String setToken(HttpServletRequest request,RedisTemplate  redisTemplate)
    {
    	if(null== TokenHelper.redisTemplate) {
            TokenHelper.redisTemplate = redisTemplate;
        }
    	String token=generateGUID();
    	//LOG.info(request.getSession().getId()+"-------------------------------sessionID");
        //第一次请求的时候设置到页面上
    	request.setAttribute(TOKEN_NAME_FIELD, token);
        //setCacheToken(request, token,1);//第一次不需要保存到缓存中
        return token;
    }
    
    /**
     * 保存一个给定键的token
     * 
     * @param token
     */
    private static void setCacheToken(String token)
    {
        try
        {
        	 String value=null;
			try {
				value = new String(("time"+System.currentTimeMillis()).getBytes(),"UTF-8");
				token=new String(token.getBytes(),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
			try{
				Integer time= 2;
				redisTemplate.opsForValue().set(token,value,time,TimeUnit.SECONDS);
			}catch(Exception e){
				redisTemplate.opsForValue().set(token,value,10,TimeUnit.SECONDS);  
			}
              
           // request.setAttribute(TOKEN_NAME_FIELD, token);
        }
        catch(IllegalStateException e)
        {
            String msg = "redis设置缓存失败: " + e.getMessage();
            LOG.error(msg, e);
            throw new IllegalArgumentException(msg);
        }
    }
    
    /**
     * 从请求域中获取给定token名字的token值
     * 
     * @param tokenName
     * @return the token String or null, if the token could not be found
     */
    public static String getToken(HttpServletRequest request, String tokenName)
    {
            if(tokenName == null)
        {
            return null;
        }
        Map params = request.getParameterMap();
        String[] tokens = (String[]) (String[]) params.get(tokenName);
        String token;
        /*if((tokens == null) || (tokens.length < 1))
        {
            LOG.warn("不能通过Token名字找到对应的Token " + tokenName);
            return null;
        }*/
        
//        token = tokens[0];
        token = request.getAttribute("token")+"";
        return token;
    }
    
    
    /**
     * 验证当前请求参数中的token是否合法 
     * 
     * @return 验证结果
     */
    public static TokenEnum validToken(HttpServletRequest request, RedisTemplate redisTemplate)
    {
    	if(null== TokenHelper.redisTemplate) {
            TokenHelper.redisTemplate = redisTemplate;
        }
    	
    	//从用户提交上来的参数里面获取到token值
        String token = getToken(request, TOKEN_NAME_FIELD);
        
        if(token == null)
        {
            if(LOG.isDebugEnabled())
            {
                LOG.info("token" + token + " -> 无效 token ");
            }
            //用户提交的表单未找到token  执行不能通过
            return TokenEnum.NOTFOUNDFROMREQUEST;
        }
        
        String cacheToken ="";
        try{
        	//从redis中获取token缓存数据
        	cacheToken=redisTemplate.opsForValue().get(token).toString();        
        }catch(Exception e){
        	//出现异常表示   token已被清除或者是第一次发送请求   系统获取不到缓存的token  表明表单现在可以提交  执行通过
            //将该token放入缓存中
            setCacheToken(token);
            //用户没有重复提交表单   执行通过
            return TokenEnum.SUCCESS;
        }
        
        if(!"".equals(cacheToken) &&cacheToken!=null)
        {
            //证明用户正在重复提交表单
            LOG.warn("寻找到了 token 匹配到了 " + cacheToken + ".");
            return TokenEnum.FAILED;
        }
        //用户没有重复提交表单   执行通过
        return TokenEnum.SUCCESS;
    }
    
    /**
     * 生成token
     * @return
     */
    public static String generateGUID()
    {
        return new BigInteger(165, RANDOM).toString(36).toUpperCase();
    }
    
    
    /**
     * 设置值
     * @param redisTemplate
     * @param map
     * @return
     */
    public  static  boolean setValue(RedisTemplate redisTemplate,Map<String,Long> map){
    	if(null== TokenHelper.redisTemplate) {
            TokenHelper.redisTemplate = redisTemplate;
        }
    	try{
    	 for(Entry<String, Long> entry: map.entrySet()) {
    		 redisTemplate.opsForValue().set(entry.getKey(),entry.getValue(),180,TimeUnit.SECONDS);  
    	 }
    	}catch(Exception e){
    		return false;
    	}
    	return true;
    }
    
    /**
     * 获取值
     * @param redisTemplate
     * @param key
     * @return
     */
    public  static TokenEnum getValue(RedisTemplate redisTemplate, String key){
    	if(null== TokenHelper.redisTemplate) {
            TokenHelper.redisTemplate = redisTemplate;
        }
    	
    	try{
    		Long timeold=(Long) redisTemplate.opsForValue().get(key);
            //查询到有时间
			if(null!=timeold)
			{
				Long timenow=System.currentTimeMillis();
				Long num=1000L * 60 * 3;
                //间隔10s
				if(timenow-timeold<=num){
                    //单机太多次了
					return TokenEnum.TOMANY;
				}
                //否则成功
				return TokenEnum.SUCCESS;
                //第一次的时候存入数据
			}else{
				Map<String,Long> map=new HashMap<String,Long>(16);
				map.put(key, System.currentTimeMillis());
				boolean flag=setValue(redisTemplate, map);
				if(flag){
					return TokenEnum.SUCCESS;
				}else{
					return TokenEnum.FAILED;
				}
			}
    		 
    	}catch(Exception e){
    		return TokenEnum.FAILED;
    	}
    	
    }
    
}
