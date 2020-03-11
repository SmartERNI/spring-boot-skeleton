package com.erni.sbbdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Clock {
    private String name;

    // Override default Jackson property ('lit')
    @JsonProperty("isLit")
    private boolean isLit;
}
