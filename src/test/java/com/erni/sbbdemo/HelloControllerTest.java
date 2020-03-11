package com.erni.sbbdemo;

import com.erni.sbbdemo.controller.HelloController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class HelloControllerTest {


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testHello(){
        //TODO why can't I call static method on HelloController here?
        assertEquals("check expected greeting", HelloController.GREETING,  HelloController.getGreeting() );
    }
}
