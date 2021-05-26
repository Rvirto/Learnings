package com.uol.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LocationWoeidDTO {

    @JsonProperty("distance")
    private String distance;

    @JsonProperty("title")
    private String title;

    @JsonProperty("location_type")
    private String locationType;

    @JsonProperty("woeid")
    private String woeid;

    @JsonProperty("latt_long")
    private String latitudeLongitude;

}
