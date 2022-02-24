package com.example.seataaccountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SeataAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeataAccountServiceApplication.class, args);
	}

}
