package com.inmyshoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class InMyShoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(InMyShoesApplication.class, args);
	}

}
