package com.owishserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SerevrAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SerevrAppApplication.class, args);
	}
}
