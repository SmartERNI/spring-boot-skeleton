package com.erni.sbbdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbbtestApplication {

	public static void main(String[] args) {

		// Avoid too-cleverness till the basics is working
		//
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(SbbtestApplication.class, args);

	}

}
