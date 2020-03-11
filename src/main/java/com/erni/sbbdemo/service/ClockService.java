package com.erni.sbbdemo.service;

import com.erni.sbbdemo.dto.ClockFields;
import com.erni.sbbdemo.dto.ClockJson;
import com.erni.sbbdemo.dto.ClockRecord;
import com.erni.sbbdemo.model.Clock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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
        // TODO how to test with null records list?
        //
        if(clockJson != null && clockJson.getRecords() != null){
            log.info("Got "+ clockJson.getRecords().size() + " clockrecords");
            for(ClockRecord clockRecord : clockJson.getRecords()){
                ClockFields clockFields = clockRecord.getFields();
                boolean isLit = "ja".equalsIgnoreCase(clockFields.getBeleuchtung());
                String bpsName = clockFields.getBps_name();
                log.info("Adding clock bps: {}, lit: {} ", bpsName, isLit);
                clockList.add(new Clock(bpsName, isLit));
            }
        }else{
            log.warn ("Got no clockrecords (null returned from jackson)");
        }

        return clockList;
    }

    // Useful in case external website returns html data only
    // From https://stackoverflow.com/a/13041033/7409029
    // todo move to some utility package
    //
    private static RestTemplate getHtmlConsumingRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        Jaxb2RootElementHttpMessageConverter jaxbMessageConverter = new Jaxb2RootElementHttpMessageConverter();
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.TEXT_HTML);
        jaxbMessageConverter.setSupportedMediaTypes(mediaTypes);
        messageConverters.add(jaxbMessageConverter);
        restTemplate.setMessageConverters(messageConverters);
        return restTemplate;
    }
}
