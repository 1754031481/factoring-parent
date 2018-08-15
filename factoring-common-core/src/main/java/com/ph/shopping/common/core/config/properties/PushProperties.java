/**  
 * @Title:  PushConfig.java   
 * @Package com.ph.shopping.common.core.config.properties   
 * @Description:    TODO(用一句话描述该文件做什么)   
 * @author: 李杰    
 * @date:   2017年6月29日 下午12:39:38   
 * @version V1.0 
 * @Copyright: 2017
 */
package com.ph.shopping.common.core.config.properties;

import com.ph.shopping.common.core.properties.InitParams;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ClassName: PushConfig
 * @Description:极光推送相关配置
 * @author: 李杰
 * @date: 2017年6月29日 下午12:39:38
 * @Copyright: 2017
 */
//@PropertySource("classpath:push.properties")
//@ConfigurationProperties(prefix = "jpush")
@Component
public class PushProperties {

	private InitParams initParams = new InitParams("/web_tianti/factoring-common-core/resources/push.properties");
	/**
	 * 极光推送appkey
	 */
	private String appKey;
	/**
	 * 极光推送appkey
	 */
	private String masterSecret;
	/**
	 * 指定离线消息保存时间(毫秒)
	 */
	private Long timeToLive;
	/**
	 * 推送环境： 0、测试环境 1、生产环境
	 */
	private String environment;
	/**
	 * 最大重试次数
	 */
	private Integer maxRetryTimes;

	public String getAppKey() {
		return initParams.getProperties().getProperty("jpush.appKey");
	}

	public String getMasterSecret() {
		return initParams.getProperties().getProperty("jpush.masterSecret");
	}

	public Long getTimeToLive() {
		return Long.valueOf(initParams.getProperties().getProperty("jpush.timeToLive"));
	}

	public String getEnvironment() {
		return initParams.getProperties().getProperty("jpush.environment");
	}

	public Integer getMaxRetryTimes() {
		return Integer.valueOf(initParams.getProperties().getProperty("jpush.maxRetryTimes"));
	}
}
