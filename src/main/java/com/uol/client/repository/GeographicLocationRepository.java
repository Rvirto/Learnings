package com.uol.client.repository;

import com.uol.client.dto.GeographicLocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

@Repository
public class GeographicLocationRepository {

    @Value("${ip.vigilante}")
    private String ipVigilantePath;

    @Value("${my.ip}")
    private String myIpPath;

    private HttpServletRequest httpServletRequest;

    private RestTemplate restTemplate;

    @Autowired
    public GeographicLocationRepository(HttpServletRequest httpServletRequest, RestTemplate restTemplate) {
        this.httpServletRequest = httpServletRequest;
        this.restTemplate = restTemplate;
    }

    public GeographicLocationDTO getGeographicLocation() {
        String httpUrlPathIpVigilante = ipVigilantePath + getMyIp() + "/geo"; //+ httpServletRequest.getRemoteAddr();
        String url = UriComponentsBuilder.fromHttpUrl(httpUrlPathIpVigilante).toUriString();

        ResponseEntity<GeographicLocationDTO> responseEntity;
        try {
            responseEntity = restTemplate.getForEntity(url, GeographicLocationDTO.class);
        } catch (Exception exception) {
            throw exception;
        }

        return responseEntity.getBody();
    }

    public String getMyIp() {
        try {
            return restTemplate.getForObject(myIpPath, String.class);
        } catch (Exception exception) {
            throw exception;
        }
    }
}
