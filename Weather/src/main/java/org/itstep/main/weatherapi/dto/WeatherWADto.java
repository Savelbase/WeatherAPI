package org.itstep.main.weatherapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.itstep.main.dto.WeatherCurrentDto;
import org.itstep.main.dto.WeatherForecastDto;
import org.itstep.main.weatherapi.weather.Current;
import org.itstep.main.weatherapi.weather.Forecast;
import org.itstep.main.weatherapi.weather.Location;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherWADto implements WeatherCurrentDto , WeatherForecastDto {
    private Location location ;
    private Current current ;
    private Forecast forecast ;
}
