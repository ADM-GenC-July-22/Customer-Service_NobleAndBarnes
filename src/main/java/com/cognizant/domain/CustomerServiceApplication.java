package com.cognizant.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CustomerServiceApplication {
	private static ConfigurableApplicationContext context;
	public static void main(String[] args) {
		context = SpringApplication.run(CustomerServiceApplication.class, args);
	}

}
