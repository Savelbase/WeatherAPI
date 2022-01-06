package org.itstep.main.openWeather.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class Weather {
    String main ;
    String description ;
    String icon ;
}
