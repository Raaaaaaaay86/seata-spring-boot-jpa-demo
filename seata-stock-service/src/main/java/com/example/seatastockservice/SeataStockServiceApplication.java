package com.example.seatastockservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SeataStockServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeataStockServiceApplication.class, args);
	}

}
