package com.uol.client.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uol.client.dto.LocationDTO;
import com.uol.client.dto.LocationWoeidDTO;
import com.uol.client.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class LocationService {

    private LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public LocationDTO getLocation(String latitudeLongitude) {
        LocationWoeidDTO locationWoeidDTO;
        LocationDTO locationDTO;
        ObjectMapper mapper = new ObjectMapper();

        HashMap<String, String> locationWoeidHashMap = locationRepository.getLocationWoeid(latitudeLongitude);
        locationWoeidDTO = mapper.convertValue(locationWoeidHashMap, LocationWoeidDTO.class);

        HashMap<String, List<String>> locationHashMap = locationRepository.getLocation(locationWoeidDTO);
        Object consolidatedWeather = locationHashMap.get("consolidated_weather").get(0);
        locationDTO = mapper.convertValue(consolidatedWeather, LocationDTO.class);

        return locationDTO;
    }
}
