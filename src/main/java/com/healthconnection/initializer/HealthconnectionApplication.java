package com.healthconnection.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.healthconnection"})
public class HealthconnectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthconnectionApplication.class, args);
	}

}
