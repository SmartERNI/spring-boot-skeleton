package com.erni.sbbdemo.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClockRecord {

    private ClockFields fields;
//    private String name;
//    private String isLit;

    public ClockRecord() {
    }

    public ClockFields getFields() {
        return fields;
    }

//    @Override
//    public String toString() {
//        return "Value{" +
//                "isLit=" + fields.getBeleuchtung() +
//                ", name='" + fields.getBps_name() + '\'' +
//                '}';
//    }
}