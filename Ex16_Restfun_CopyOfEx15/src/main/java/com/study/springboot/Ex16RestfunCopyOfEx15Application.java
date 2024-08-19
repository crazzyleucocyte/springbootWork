package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Ex16RestfunCopyOfEx15Application {

	public static void main(String[] args) {
		SpringApplication.run(Ex16RestfunCopyOfEx15Application.class, args);
	}

}
