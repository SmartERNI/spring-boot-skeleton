package com.erni.sbbdemo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Clock {
    private String name;
    private boolean isLit;
}
