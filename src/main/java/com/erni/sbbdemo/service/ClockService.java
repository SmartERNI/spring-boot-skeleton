package com.erni.sbbdemo.service;

import com.erni.sbbdemo.dto.ClockFields;
import com.erni.sbbdemo.dto.ClockJson;
import com.erni.sbbdemo.dto.ClockRecord;
import com.erni.sbbdemo.model.Clock;
import com.erni.sbbdemo.util.MiscUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Slf4j
@Service
public class ClockService {

    public static final int ALL_ROWS = -1;
    // See https://data.sbb.ch/explore/dataset/haltestelle-uhr/api for more
    // Note: getClocks() appends &rows=nnn to this URL
    //
    private static String SBB_CLOCKS_URL = "https://data.sbb.ch/api/records/1.0/search/?dataset=haltestelle-uhr";

    @Autowired
    RestTemplate restTemplate;

    public List<Clock> getClocks(Integer rows){

        List<Clock> clockList = new ArrayList<>();

        log.debug("Requesting data for {} clocks", rows);
        ClockJson clockJson = restTemplate.getForObject(SBB_CLOCKS_URL+"&rows="+rows,ClockJson.class);

        // walk records, make clocks...return clock list
        //
        if(clockJson != null && clockJson.getRecords() != null){
            log.info("Got "+ clockJson.getRecords().size() + " clockrecords");
            Map<String,Integer> debugClockCounts = new TreeMap<>();
            for(ClockRecord clockRecord : clockJson.getRecords()){
                ClockFields clockFields = clockRecord.getFields();
                String bpsName = clockFields.getBps_name();
                boolean isLit = "ja".equalsIgnoreCase(clockFields.getBeleuchtung());
                log.debug("Clock: {}, {} ", bpsName, isLit ? "lit" : "not lit");
                clockList.add(new Clock(bpsName, isLit));
                bumpCount(debugClockCounts,bpsName);
            }
            log.info("Sorted clocks summary: {}", MiscUtils.sortByValue(debugClockCounts));
        }else{
            log.warn ("Got no clockrecords (null returned from jackson)");
        }

        return clockList;
    }

    private static void bumpCount(Map<String, Integer> counts, String bpsName) {
        int newCount=1;
        if(counts.containsKey(bpsName)){
            newCount+=counts.get(bpsName);
        }
        counts.put(bpsName,newCount);
    }

}
