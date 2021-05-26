package com.uol.client.repository;

import com.uol.client.dto.LocationWoeidDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@Repository
public class LocationRepository {

    @Value("${url.metaweather.lattlong}")
    private String lattlongMetaWeatherPath;

    @Value("${url.metaweather.location}")
    private String locationMetaWeatherPath;

    private RestTemplate restTemplate;

    @Autowired
    public LocationRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public HashMap<String, List<String>> getLocation(LocationWoeidDTO locationWoeidDTO) {
        String locationWeatherPath = locationMetaWeatherPath + locationWoeidDTO.getWoeid();

        ResponseEntity<Object> responseEntity;
        try {
            responseEntity = restTemplate.getForEntity(locationWeatherPath, Object.class);
        } catch (Exception exception) {
            throw exception;
        }

        return (HashMap<String, List<String>>) responseEntity.getBody();
    }

    public HashMap<String, String> getLocationWoeid(String latitudeLongitude) {
        try {
            String longitudeLatitudePath = lattlongMetaWeatherPath + latitudeLongitude;
            List<Object> objectList = (List<Object>) restTemplate
                                .getForObject(longitudeLatitudePath, Object.class);
             return (HashMap<String, String>) objectList.get(0);
        } catch (Exception exception) {
            throw exception;
        }
    }
}
