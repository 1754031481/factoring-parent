/**  
 * @Title:  BjUrlProperties.java   
 * @Package com.ph.shopping.common.core.config.properties   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 李杰    
 * @date:   2017年7月11日 下午2:08:18   
 * @version V1.0 
 * @Copyright: 2017
 */  
package com.ph.shopping.common.core.config.properties;

import com.ph.shopping.common.core.properties.InitParams;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**   
 * @ClassName:  BjUrlProperties   
 * @Description:北京提供的连接地址   
 * @author: 李杰
 * @date:   2017年7月11日 下午2:08:18     
 * @Copyright: 2017
 */
//@ConfigurationProperties(prefix = "bj")
@Component
public class BjUrlProperties {

	private InitParams initParams = new InitParams("/web_tianti/factoring-common-core/resources/bjurl.properties");

	/**
	 * 注册校验url
	 */
	private String registerCheckUrl;
	/**
	 * 登录校验url
	 */
	private String loginCheckUrl;
	/**
	 * 添加猎头url
	 */
	private String addHeadhuntingUrl;
	/**
	 * 获取猎头url
	 */
	private String getHeadhuntingUrl;
	/**
	 *验证二要素
	 */
	private String twoElementUrl;
	/**
	 *普惠注册
	 */
	private String phRegisterUrl;

	public String getRegisterCheckUrl() {
		return initParams.getProperties().getProperty("bj.registerCheckUrl");
	}

	public String getLoginCheckUrl() {
		return initParams.getProperties().getProperty("bj.loginCheckUrl");
	}

	public String getAddHeadhuntingUrl() {
		return initParams.getProperties().getProperty("bj.addHeadhuntingUrl");
	}

	public String getGetHeadhuntingUrl() {
		return initParams.getProperties().getProperty("bj.getHeadhuntingUrl");
	}

	public String getTwoElementUrl() {
		return initParams.getProperties().getProperty("bj.twoElementUrl");
	}

	public String getPhRegisterUrl() {
		return initParams.getProperties().getProperty("bj.phRegisterUrl");
	}
}
