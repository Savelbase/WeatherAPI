package org.itstep.main.openWeather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.itstep.main.dto.WeatherForecastDto;
import org.itstep.main.openWeather.weather.City;
import org.itstep.main.openWeather.weather.WeatherObject;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class WeatherOpenWMForecast implements WeatherForecastDto {
    private List<WeatherObject> list ;
    private City city ;
}
