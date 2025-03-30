package com.hugo83.spring_new;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringNewApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringNewApplication.class, args);

		System.out.println("Hola, SpringBoot!");
	}

}
