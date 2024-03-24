package com.example.customerbll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class CustomerBllApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomerBllApplication.class, args);
	}

}
