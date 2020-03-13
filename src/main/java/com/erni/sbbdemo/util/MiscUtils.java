package com.erni.sbbdemo.util;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class MiscUtils {
    // Credit Carter Page https://stackoverflow.com/a/2581754/7409029
    // Sort a map on values, without streaming.
    //
    // Alternative to using this:
    //
    // Credit Brian Goetz https://stackoverflow.com/a/23846961/7409029
    //clockCounts.entrySet().stream()
    //  .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
    //  .forEach(e -> log.info("entry: {}", e));
    //
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    // Useful in case external website returns html data only
    // From https://stackoverflow.com/a/13041033/7409029
    //
    public static RestTemplate getHtmlConsumingRestTemplate(){
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
