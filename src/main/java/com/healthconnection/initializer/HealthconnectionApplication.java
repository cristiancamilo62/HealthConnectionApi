package com.healthconnection.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.healthconnection.application.output.repository")
@EntityScan(basePackages = "com.healthconnection.application.output.model")
@ComponentScan(basePackages = {"com.healthconnection"})
public class HealthconnectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthconnectionApplication.class, args);
	}

}
