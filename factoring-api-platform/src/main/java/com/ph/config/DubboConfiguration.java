/**
 * 
 */
package com.ph.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.ph.shopping.common.core.properties.InitParams;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @项目：factoring-service-member
 *
 * @描述：dubbox消费者配置
 *
 * 				@作者： Mr.chang
 *
 * @创建时间：2017年3月10日
 *
 * 					@Copyright @2017 by Mr.chang
 *
 * @author YUEYUE
 */
@Configuration
public class DubboConfiguration {

	private static InitParams initParams = new InitParams("/web_tianti/factoring-api-platform/resource/dubbo.properties");

	private String applicationName;

	private String protocol;

	private String registryAddress;

	private int timeout;

	private int retries;

	/**
	 * 设置dubbo扫描包
	 * 
	 * @return
	 */
	@Bean
	public static AnnotationBean annotationBean() {
		AnnotationBean annotationBean = new AnnotationBean();
		annotationBean.setPackage(initParams.getProperties().getProperty("dubbo.annotation.package"));
		return annotationBean;
	}

	/**
	 * 注入dubbo上下文
	 *
	 * @return
	 */
	@Bean
	public ApplicationConfig applicationConfig() {
		// 当前应用配置
		ApplicationConfig applicationConfig = new ApplicationConfig();
		applicationConfig.setName(getApplicationName());
		applicationConfig.setLogger("slf4j");
		return applicationConfig;
	}

	/**
	 * 注入dubbo注册中心配置,基于zookeeper
	 *
	 * @return
	 */
	@Bean
	public RegistryConfig registryConfig() {
		// 连接注册中心配置
		RegistryConfig registry = new RegistryConfig();
		registry.setProtocol(getProtocol());
		registry.setAddress(getRegistryAddress());
		//设置启动时不检查注册中心
		registry.setCheck(false);
		return registry;
	}

	/**
	 * dubbo监控中心
	 * @return
	 */
	@Bean
	public MonitorConfig monitorConfig() {
		MonitorConfig mc = new MonitorConfig();
		mc.setProtocol("registry");
		return mc;
	}

	/**
	 * dubbo消费
	 *
	 * @param applicationConfig
	 * @param registryConfig
	 * @return
	 */
	@Bean(name = "consumer")
	public ConsumerConfig providerConfig(ApplicationConfig applicationConfig, RegistryConfig registryConfig,MonitorConfig monitorConfig) {
		ConsumerConfig consumeConfig = new ConsumerConfig();
		consumeConfig.setApplication(applicationConfig);
		consumeConfig.setRegistry(registryConfig);
		//设置不检查服务提供者
		consumeConfig.setCheck(false);
		consumeConfig.setRetries(getRetries());
		consumeConfig.setTimeout(getTimeout());
		consumeConfig.setMonitor(monitorConfig);
		return consumeConfig;
	}

	/**
	 * @return the applicationName
	 */
	public String getApplicationName() {
		return initParams.getProperties().getProperty("dubbo.application.name");
	}

	/**
	 * @param applicationName the applicationName to set
	 */
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	/**
	 * @return the protocol
	 */
	public String getProtocol() {
		return initParams.getProperties().getProperty("dubbo.registry.protocol");
	}

	/**
	 * @param protocol the protocol to set
	 */
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	/**
	 * @return the registryAddress
	 */
	public String getRegistryAddress() {
		return initParams.getProperties().getProperty("dubbo.registry.address");
	}

	/**
	 * @param registryAddress the registryAddress to set
	 */
	public void setRegistryAddress(String registryAddress) {
		this.registryAddress = registryAddress;
	}

	/**
	 * @return the timeout
	 */
	public int getTimeout() {
		return Integer.parseInt(initParams.getProperties().getProperty("dubbo.consumer.timeout"));
	}

	/**
	 * @param timeout the timeout to set
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getRetries() {
		return Integer.parseInt(initParams.getProperties().getProperty("dubbo.consumer.retries"));
	}
	public void setRetries(int retries) {
		this.retries = retries;
	}
}
