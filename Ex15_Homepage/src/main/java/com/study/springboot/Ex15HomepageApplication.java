package com.study.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Ex15HomepageApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex15HomepageApplication.class, args);
	}

}
