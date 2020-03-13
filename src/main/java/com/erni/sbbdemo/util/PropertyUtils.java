package com.erni.sbbdemo.util;

import com.erni.sbbdemo.SbbdemoApplication;
import org.slf4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PropertyUtils {

    public static void logSortedSystemProperties(Logger log) {
        log.info("=============System properties=============\n");
        Map<Object,Object> sortedProperties = new TreeMap<>();
        for(Map.Entry<Object,Object> pair : System.getProperties().entrySet()){
//            if(!pair.getKey().equals("java.class.path")) {
                sortedProperties.put(pair.getKey(), pair.getValue());
//            }
        }
        for(Map.Entry<Object,Object> pair : sortedProperties.entrySet()){
            log.info("{} = {}", pair.getKey(), pair.getValue());
        }
    }

    public static List<String> readApplicationPropertiesFile() {
        try{
            List<String> lines = Files.readAllLines(
                    Paths.get(PropertyUtils.class.getResource("/application.properties").toURI()),
                    Charset.defaultCharset()
            );
            return lines;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
