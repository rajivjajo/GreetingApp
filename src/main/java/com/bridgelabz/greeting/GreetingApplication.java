package com.bridgelabz.greeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreetingApplication {
	public static void main(String[] args) {
		SpringApplication.run(GreetingApplication.class, args);
		System.out.println("Welcome to greeting app!");
	}

}
