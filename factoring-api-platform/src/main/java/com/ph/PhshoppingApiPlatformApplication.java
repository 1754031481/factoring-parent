package com.ph;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author 荐家跃
 * @date 2018/5/3 15:30
 * @Title: PhshoppingApiPlatformApplication
 * @Description: 启动项
 * @Version:1.0.0
 */
@SpringBootApplication
@EnableScheduling
//@EnableApolloConfig
public class PhshoppingApiPlatformApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(PhshoppingApiPlatformApplication.class, args);
	}
}
