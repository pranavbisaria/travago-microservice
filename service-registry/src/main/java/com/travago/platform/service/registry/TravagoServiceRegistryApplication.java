package com.travago.platform.service.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TravagoServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravagoServiceRegistryApplication.class, args);
	}

}
