package com.erni.sbbdemo.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

//    private String bpsName;
//    private String beleuchtung;//ja or nein


@JsonIgnoreProperties(ignoreUnknown = true)
public class ClockJson {

//    private String type;
    private List<ClockRecord> records;

    public ClockJson() {    }
//    public String getType() {    return type;    }
//    public void setType(String type) {        this.type = type;    }

    public List<ClockRecord> getRecords() {   return records;    }

    public void setRecords(List<ClockRecord> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "ClockQuote{" +
//                "type='" + type + '\'' +
                ", value=" + records +
                '}';
    }
}