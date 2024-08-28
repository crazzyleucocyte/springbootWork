package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Ex17ReactTestCopyOfEx16Application {

	public static void main(String[] args) {
		SpringApplication.run(Ex17ReactTestCopyOfEx16Application.class, args);
	}

}
