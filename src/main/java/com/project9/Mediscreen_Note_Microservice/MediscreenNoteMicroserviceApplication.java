package com.project9.Mediscreen_Note_Microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MediscreenNoteMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediscreenNoteMicroserviceApplication.class, args);
	}

}
