package com.erni.sbbdemo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erni.sbbdemo.Clock;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class HelloController {

    public static final String GREETING = "Heidi hei SBB World!";
    public static String getGreeting(){ return GREETING; }

    private String dummyProperty = "Just to test lombok @data annotation";

    //TODO: Controller should delegate to services
    //
    @RequestMapping("/clocks")
    List<Clock> getClocks() {
        log.debug("Houston, we entered clocks()");
        List<Clock> clocks = new ArrayList<>();
        clocks.add(new Clock("Lausanne", true));
        clocks.add(new Clock("Lausanne", true));
        clocks.add(new Clock("Lausanne", true));
        clocks.add(new Clock("Bern", true));
        //services can query data and services..
        //
        return clocks;
    }

}
