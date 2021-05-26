package com.uol.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GeographicLocationDTO {

    @JsonProperty("ip")
    private String ip;

    @JsonProperty("city")
    private String city;

    @JsonProperty("region")
    private String region;

    @JsonProperty("country")
    private String country;

    @JsonProperty("loc")
    private String location;

    @JsonProperty("postal")
    private String postal;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("readme")
    private String readme;

}
