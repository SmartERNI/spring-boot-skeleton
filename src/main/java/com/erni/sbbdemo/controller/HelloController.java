package com.erni.sbbdemo.controller;

import com.erni.sbbdemo.model.Clock;
import com.erni.sbbdemo.service.ClockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
public class HelloController {

    public static final String GREETING = "Hello from SpringBoot skeleton";
    @Autowired
    private ClockService clockService;

    public static String getGreeting(){ return GREETING; }

    @GetMapping("/clocks")
    public List<Clock> getClocks(@RequestParam(name="rows", defaultValue=""+ClockService.ALL_ROWS) Integer rows) {
        log.info("Entered clocks() with {} rows", rows);
        return clockService.getClocks(rows);
    }

    @GetMapping("/dummyclocks")
    public List<Clock> getDummyClocks() {
        log.debug("Houston, we entered dummyclocks()");
        List<Clock> clocks = new ArrayList<>();
        clocks.add(new Clock("Lausanne", true));
        clocks.add(new Clock("Lausanne", true));
        clocks.add(new Clock("Lausanne", false));
        clocks.add(new Clock("Bern", true));
        return clocks;
    }

    @GetMapping("/hello")
    public String getHello() {
        log.debug("Houston, we entered getHello()");
        return GREETING;
    }

}
