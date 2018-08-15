package com.ph.shopping.common.core.aspect;

import com.ph.shopping.common.core.properties.InitParams;
import com.ph.shopping.common.core.util.JedisUtils;
import com.ph.shopping.common.util.signutil.SignUtils;
import org.alqframework.pay.weixin.util.MD5Util;
import com.ph.shopping.common.util.result.Result;
import org.alqframework.result.ResultUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
@Aspect
@Order(2)
public class AdviceExplosionproof {
    private InitParams initParams = new InitParams("/web_tianti/factoring-common-config/resources/application.properties");


    private static Log logger = LogFactory
            .getLog(AdviceExplosionproof.class);

    // 方法执行的前后调用
    @Around("@annotation(com.ph.shopping.common.core.anno.Explosionproof )")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        logger.info(Thread.currentThread().getName() + "防爆线程名称------------------------");
        JedisUtils jedisUtils = JedisUtils.getRu(initParams);
        Result result = new Result();
        //获取请求路径
        String requestURI = request.getRequestURI();
        logger.info("请求路径:" + requestURI);
        Map<String, String[]> map = request.getParameterMap();
        String sessionId = request.getSession().getId();
        logger.info("sessionId:" + sessionId);
        String signData = SignUtils.mapToLinkString2(map);
        signData += sessionId;
        String sign = "";
        byte[] b = null;
        try {
            b = (MD5Util.MD5Encode(signData, "utf-8") + "TY" + requestURI).getBytes("utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(signData + ":签名加密异常");
        }
        if (b != null) {
            sign = Base64Utils.encodeToString(b);
        }
        logger.info("sign=" + sign + "****************************");
        Boolean num = jedisUtils.exists(sign);
        if (!num) {
            String setex = jedisUtils.setex(sign, sign, 10);//设置失效时间
            logger.info("方法:" + point.getSignature().getName() + "防爆通过，准备添加redis");
            final String ok = "OK";
            if (ok.equals(setex)) {
                logger.info("方法:" + point.getSignature().getName() + "添加redis成功，准备执行");
                Object object = point.proceed();
                Class<? extends Object> class1 = object.getClass();
                Class<? extends Result> class2 = result.getClass();
                if (class1 != class2) {
                    return object;
                }
                result = (Result) object;
                if (Integer.parseInt(result.getCode()) != 1) {
                    logger.info("方法:" + point.getSignature().getName() + "执行，返回失败，准备删除redis");
                    Long hdel = jedisUtils.del(sign);
                    if (hdel.longValue() > 0L) {
                        logger.info("方法:" + point.getSignature().getName() + "删除redis成功");
                    } else {
                        logger.info("方法:" + point.getSignature().getName() + "删除redis失败");
                    }
                }
                return result;
            } else {
                logger.info("方法:" + point.getSignature().getName() + "添加redis失败，拦截");
                return ResultUtils.returnError("提交异常,请联系管理员");
            }
        } else {
            logger.info("方法:" + point.getSignature().getName() + "防爆处理，拦截");
            return ResultUtils.returnError("请勿重复提交");
        }
    }
}  