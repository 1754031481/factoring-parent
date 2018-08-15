/**
 * 
 */
package com.ph.shopping.config;

import com.alibaba.dubbo.config.*;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.ph.shopping.common.core.properties.InitParams;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @项目：factoring-service-member
 *
 * @描述：
 *
 * @作者： Mr.chang
 *
 * @创建时间：2017年3月10日
 *
 * @Copyright @2017 by Mr.chang
 */

@Configuration
public class DubboConfiguration {

	private static InitParams initParams = new InitParams("/web_tianti/factoring-service-pay/resource/dubbo.properties");
	
    private String applicationName;

    private String protocol;

    private String registryAddress;

    private String protocolName;

    private int protocolPort;

    private int timeout;

    private int retries;

    private int delay;

	private String filter;
    
    
    /**
     * 设置dubbo扫描包
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
		applicationConfig.setName(this.getApplicationName());
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
		registry.setCheck(false);
		return registry;
	}

	/**
	 * 默认基于dubbo协议提供服务
	 *
	 * @return
	 */
	@Bean
	public ProtocolConfig protocolConfig() {
		// 服务提供者协议配置
		ProtocolConfig plc = new ProtocolConfig();
		plc.setName(getProtocolName());
		plc.setPort(getProtocolPort());
		plc.setThreads(200);
		return plc;
	}

	/**
	 * dubbo监控
	 * @return
	 */
	@Bean
	public MonitorConfig monitorConfig() {
		MonitorConfig mc = new MonitorConfig();
		mc.setProtocol("registry");
		return mc;
	}

	/**
	 * dubbo服务提供
	 *
	 * @param applicationConfig
	 * @param registryConfig
	 * @param protocolConfig
	 * @return
	 */
	@Bean(name="payProvider")
	public ProviderConfig providerConfig(ApplicationConfig applicationConfig, RegistryConfig registryConfig, ProtocolConfig protocolConfig,MonitorConfig monitorConfig) {
		ProviderConfig pc = new ProviderConfig();
		pc.setApplication(applicationConfig);
		pc.setRegistry(registryConfig);
		pc.setProtocol(protocolConfig);
		pc.setMonitor(monitorConfig);
		pc.setTimeout(getTimeout());
		pc.setRetries(getRetries());
		pc.setDelay(getDelay());
		return pc;
	}

	/**
	 * dubbo消费
	 *
	 * @param applicationConfig
	 * @param registryConfig
	 * @param monitorConfig
	 * @return
	 */
	@Bean(name="payConsumer")
	public ConsumerConfig consumerConfig(ApplicationConfig applicationConfig, RegistryConfig registryConfig, MonitorConfig monitorConfig) {
		ConsumerConfig consumer = new ConsumerConfig();
		consumer.setApplication(applicationConfig);
		consumer.setRegistry(registryConfig);
		consumer.setMonitor(monitorConfig);
		consumer.setCheck(false);//设置不检查服务提供者
//		consumer.setFilter(getFilter());
		return consumer;
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
	 * @return the protocolName
	 */
	public String getProtocolName() {
		return initParams.getProperties().getProperty("dubbo.protocol.name");
	}

	/**
	 * @param protocolName the protocolName to set
	 */
	public void setProtocolName(String protocolName) {
		this.protocolName = protocolName;
	}

	/**
	 * @return the protocolPort
	 */
	public int getProtocolPort() {
		return Integer.valueOf(initParams.getProperties().getProperty("dubbo.protocol.port"));
	}

	/**
	 * @param protocolPort the protocolPort to set
	 */
	public void setProtocolPort(int protocolPort) {
		this.protocolPort = protocolPort;
	}

	/**
	 * @return the timeout
	 */
	public int getTimeout() {
		return Integer.valueOf(initParams.getProperties().getProperty("dubbo.provider.timeout"));
	}

	/**
	 * @param timeout the timeout to set
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	/**
	 * @return the retries
	 */
	public int getRetries() {
		return Integer.valueOf(initParams.getProperties().getProperty("dubbo.provider.retries"));
	}

	/**
	 * @param retries the retries to set
	 */
	public void setRetries(int retries) {
		this.retries = retries;
	}

	/**
	 * @return the delay
	 */
	public int getDelay() {
		return  Integer.valueOf(initParams.getProperties().getProperty("dubbo.provider.delay"));
	}

	/**
	 * @param delay the delay to set
	 */
	public void setDelay(int delay) {
		this.delay = delay;
	}

	public String getFilter() {
		return initParams.getProperties().getProperty("dubbo.consumer.filter");
	}

}
