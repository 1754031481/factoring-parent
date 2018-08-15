/**  
 * @Title:  SmsProperties.java   
 * @Package com.wholesale.config.properties   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 李杰    
 * @date:   2017年7月5日 上午9:41:19   
 * @version V1.0 
 * @Copyright: 2017
 */  
package com.ph.shopping.common.core.config.properties;

import com.ph.shopping.common.core.properties.InitParams;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**   
 * @ClassName:  SmsProperties   
 * @Description:短息相关配置   
 * @author: 李杰
 * @date:   2017年7月5日 上午9:41:19     
 * @Copyright: 2017
 */
@Component
public class SmsProperties {

	private InitParams initParams = new InitParams("/web_tianti/factoring-common-core/resources/sms.properties");
	/**
	 * 云片appkey
	 */
	private String ypApikey;
	/**
	 * 云片短信url
	 */
	private String ypUrl;
	/**
	 * 最大缓存时间
	 */
	private Long maxTime;

	public String getYpApikey() {
		return initParams.getProperties().getProperty("sms.ypApikey");
	}

	public String getYpUrl() {
		return initParams.getProperties().getProperty("sms.ypUrl");
	}

	public Long getMaxTime() {
		return Long.valueOf(initParams.getProperties().getProperty("sms.maxTime"));
	}
}
