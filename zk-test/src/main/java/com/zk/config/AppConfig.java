package com.zk.config;

import com.zk.service.ImportService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.zk")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

	@Bean
	public ImportService createBeanService(){
		System.out.println("import service");
		return new ImportService();
	}

}
