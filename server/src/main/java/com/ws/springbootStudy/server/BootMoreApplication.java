package com.ws.springbootStudy.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 服务的启动类
 */
@SpringBootApplication
//此处自定义数据源信息的key，需要引用相对应的配置文件
@ImportResource(locations = "classpath:spring/spring-jdbc.xml")
@MapperScan(basePackages = "com.ws.springbootStudy.mapper")
@EnableCaching
@EnableScheduling
public class BootMoreApplication extends SpringBootServletInitializer {

	@Autowired
	private Environment environment;

	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper;
	}

	/*
	 * 指定服务的启动方式，不使用内嵌的tomcat启动
	 */
	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BootMoreApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(BootMoreApplication.class, args);
	}
}
