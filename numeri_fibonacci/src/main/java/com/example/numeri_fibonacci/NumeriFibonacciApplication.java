package com.example.numeri_fibonacci;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NumeriFibonacciApplication {

	private static final Logger log = LoggerFactory.getLogger(NumeriFibonacciApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(NumeriFibonacciApplication.class, args);
		log.info("HELLO");
	}

}
