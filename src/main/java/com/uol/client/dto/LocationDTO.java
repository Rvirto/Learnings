package com.uol.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LocationDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("weather_state_name")
    private String weatherStateName;

    @JsonProperty("weather_state_abbr")
    private String weatherStateAbbr;

    @JsonProperty("wind_direction_compass")
    private String windDirectionCompass;

    @JsonProperty("created")
    private String created;

    @JsonProperty("applicable_date")
    private String applicableDate;

    @JsonProperty("min_temp")
    private String minTemp;

    @JsonProperty("max_temp")
    private String maxTemp;

    @JsonProperty("the_temp")
    private String theTemp;

    @JsonProperty("wind_speed")
    private String windSpeed;

    @JsonProperty("wind_direction")
    private String windDirection;

    @JsonProperty("air_pressure")
    private String airPressure;

    @JsonProperty("humidity")
    private String humidity;

    @JsonProperty("visibility")
    private String visibility;

    @JsonProperty("predictability")
    private String predictability;
}
