package com.optum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.optum.repository")
public class RestForPostmanApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestForPostmanApplication.class, args);
	}
}
