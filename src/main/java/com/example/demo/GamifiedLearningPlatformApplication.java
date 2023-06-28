package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.config.SecurityConfig;

@SpringBootApplication
@EnableMongoRepositories
@Import(SecurityConfig.class)
@CrossOrigin(origins = "*")
public class GamifiedLearningPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamifiedLearningPlatformApplication.class, args);
	}

}
