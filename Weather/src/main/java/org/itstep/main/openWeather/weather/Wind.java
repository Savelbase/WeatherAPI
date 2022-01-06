package org.itstep.main.openWeather.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class Wind {
    double speed ;
    double deg;
}
