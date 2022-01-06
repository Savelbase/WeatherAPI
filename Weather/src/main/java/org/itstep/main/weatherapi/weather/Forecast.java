package org.itstep.main.weatherapi.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties (ignoreUnknown = true)
public class Forecast {
   private ForecastDay [] forecastday ;
}
