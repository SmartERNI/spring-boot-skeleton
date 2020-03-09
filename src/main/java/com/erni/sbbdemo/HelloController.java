package com.erni.sbbdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    public static final String GREETING = "Hello SBB World!";
    public static String getGreeting(){ return GREETING; }

    @RequestMapping("/hello")
    String home() {
        return getGreeting();
        //TODO: Controller should delegate to services, and
        //services can query data and services..
        //
    }

}
