package com.bogads.intbnk_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class IntbnkBackApplication {
	public static void main(String[] args) {
		SpringApplication.run(IntbnkBackApplication.class, args);
	}
}
