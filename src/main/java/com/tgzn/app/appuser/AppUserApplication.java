package com.tgzn.app.appuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.tgzn.app.appuser.mapper")
public class AppUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppUserApplication.class, args);
	}
}
