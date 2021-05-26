package com.uol.client.service;

import com.uol.client.dto.GeographicLocationDTO;
import com.uol.client.repository.GeographicLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeographicLocationService {

    private GeographicLocationRepository geographicLocationRepository;

    @Autowired
    public GeographicLocationService(GeographicLocationRepository geographicLocationRepository) {
        this.geographicLocationRepository = geographicLocationRepository;
    }

    public GeographicLocationDTO getGeographicLocation() {
        return geographicLocationRepository.getGeographicLocation();
    }
}
