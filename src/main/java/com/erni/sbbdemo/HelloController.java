package com.erni.sbbdemo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Data
@RestController
public class HelloController {

    public static final String GREETING = "Heidi hei SBB World!";
    public static String getGreeting(){ return GREETING; }

    private String dummyProperty = "Just to test lombok @data annotation";

    @RequestMapping("/hello")
    String home() {
        // FIXED Why Lombok annotations not working?
        // HOW By installing IDE lombok plugin
        // String dummy = getDummyProperty();
        log.debug("Houston, we entered home()");
        String dummy  = getDummyProperty();
        return getGreeting();
        //TODO: Controller should delegate to services, and
        //services can query data and services..
        //
    }

}
