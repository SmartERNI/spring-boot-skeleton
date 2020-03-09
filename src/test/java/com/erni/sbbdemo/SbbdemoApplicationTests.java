package com.erni.sbbdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbbdemoApplicationTests {

	@Test
	void contextLoads() {
	}

	// TODO tests for class X should be in related class XBlahTest ..
	// This is to verify tests are doing something useful
	//
	@Test
	void twoPlusTwoIsFour(){
		// Why can't I call a static method on com.erni.sbbdemo.SbbdemoApplication?
		//
//		int sum = com.erni.sbbdemo.SbbdemoApplication.sum(2, 3); //fails to see class!
	}

}
