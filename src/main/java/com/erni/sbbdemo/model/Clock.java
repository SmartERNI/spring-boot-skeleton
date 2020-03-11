package com.erni.sbbdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Clock {
    private String name;
    private boolean isLit;
}
