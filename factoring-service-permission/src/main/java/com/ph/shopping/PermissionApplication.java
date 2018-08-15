/**
 * 
 */
package com.ph.shopping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @项目：factoring-service-permission
 *
 * @描述：
 *
 * @作者： Mr.chang
 *
 * @创建时间：2017年3月10日
 *
 * @Copyright @2017 by Mr.chang"com.lorne",
 */
@SpringBootApplication(scanBasePackages={"com.ph"})
@MapperScan(basePackages = "com.ph.shopping.facade.mapper")
@EnableAspectJAutoProxy(proxyTargetClass = true,exposeProxy = true)
@EnableTransactionManagement(order = 2)
//@EnableApolloConfig
public class PermissionApplication {
	
	public static void main(String[] args)throws Exception {
		System.setProperty("dubbo.application.logger","slf4j");
		SpringApplication.run(PermissionApplication.class, args);
		System.out.print("----------------");
	}
	
	/**
	 * 设置tomcat端口号
	 * @return
	 */
	@Bean
	public EmbeddedServletContainerFactory servletContainer(){
		TomcatEmbeddedServletContainerFactory factory=new TomcatEmbeddedServletContainerFactory();
		factory.setPort(10005);
		return factory;
	}

}