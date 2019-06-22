package com.springmicroservice.disoverserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DisoverServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisoverServerApplication.class, args);
	}

}
