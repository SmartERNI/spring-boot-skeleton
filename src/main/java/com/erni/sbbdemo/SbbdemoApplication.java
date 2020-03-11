package com.erni.sbbdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

// Run in a cmd shell (preferably not gitbash, as you can't stop
// it in gitbash with Ctrl+C) using e.g.
//
// mvn spring-boot:run
//
@SpringBootApplication
public class SbbdemoApplication {

	public static void main(String[] args) {

		// Avoid acrobatics till basics work ..
		//
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(SbbdemoApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}

}
