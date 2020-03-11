package com.erni.sbbdemo.controller;

import com.erni.sbbdemo.model.Clock;
import com.erni.sbbdemo.service.ClockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
public class HelloController {

    public static final String GREETING = "Heidi hei SBB World!";
    @Autowired
    private ClockService clockService;

    public static String getGreeting(){ return GREETING; }

    //TODO: Controller should delegate to services
    //
    @GetMapping("/clocks")
    public List<Clock> getClocks() {
        log.debug("Houston, we entered clocks()");
//        List<Clock> clocks = new ArrayList<>();
//        clocks.add(new Clock("Lausanne", true));
//        clocks.add(new Clock("Lausanne", true));
//        clocks.add(new Clock("Lausanne", true));
//        clocks.add(new Clock("Bern", true));
//        return clocks;

        return clockService.getClocks();
    }

}
