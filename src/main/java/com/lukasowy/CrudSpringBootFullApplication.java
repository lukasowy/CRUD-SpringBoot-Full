package com.lukasowy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
public class CrudSpringBootFullApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringBootFullApplication.class, args);
	}
}
