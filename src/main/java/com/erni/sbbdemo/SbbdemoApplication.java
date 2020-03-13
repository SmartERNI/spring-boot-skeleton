package com.erni.sbbdemo;

import com.erni.sbbdemo.util.PropertyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

// (Windows) Run in a cmd shell (preferably not gitbash, as you can't stop
// it in gitbash with Ctrl+C) using e.g.
//
// mvn spring-boot:run
//
@Slf4j
@SpringBootApplication
//@EnableConfigurationProperties
public class SbbdemoApplication {

	public static void main(String[] args) {

		// Avoid acrobatics till basics work ..
		//
		System.setProperty("spring.devtools.restart.enabled", "false");

		// Some diagnostics if needed
		//
		PropertyUtils.logSortedSystemProperties(log);
		log.info("application.properties contains {}", PropertyUtils.readApplicationPropertiesFile());

		SpringApplication.run(SbbdemoApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}

}
