package com.balstaalpin.balstaalpin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.balstaalpin.balstaalpin.repository")
@SpringBootApplication
public class BalstaalpinApplication {

	public static void main(String[] args) {
		SpringApplication.run(BalstaalpinApplication.class, args);
	}
}
