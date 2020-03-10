package com.erni.sbbdemo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

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
		// fixed Why can't I call a static method on com.erni.sbbdemo.SbbdemoApplication?
		// fix: test classes must be in same module (intellij) as COT
		assertEquals("Simple 2+2==4 check", 4,SbbdemoApplication.sum(2,2));
	}

}
