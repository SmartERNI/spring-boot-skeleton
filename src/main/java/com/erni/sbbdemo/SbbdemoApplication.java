package com.erni.sbbdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbbdemoApplication {

	public static void main(String[] args) {

		// Avoid acrobatics till basics work ..
		//
		System.setProperty("spring.devtools.restart.enabled", "false");

		SpringApplication.run(SbbdemoApplication.class, args);

	}

	// Temporary... trying to get junit5 to cooperate..
	//
	public static int sum(int a, int b) {
		return a + b;
	}

}
