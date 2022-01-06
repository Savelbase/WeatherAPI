package org.itstep.main.weatherapi.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Current {
    private Double temp_c;
    private Double wind_mph;
    private Condition condition;
}
