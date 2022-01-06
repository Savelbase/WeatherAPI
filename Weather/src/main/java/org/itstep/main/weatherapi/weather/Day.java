package org.itstep.main.weatherapi.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Day {
    private Double avgtemp_c;
    private Double avgvis_miles;
    private Condition condition;
}
