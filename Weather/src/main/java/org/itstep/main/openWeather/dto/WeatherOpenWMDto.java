package org.itstep.main.openWeather.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.itstep.main.dto.WeatherCurrentDto;
import org.itstep.main.openWeather.weather.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherOpenWMDto implements WeatherCurrentDto {
    Weather [] weather ;
    Main main ;
    Wind wind ;
    Sys sys ;
    String name ;
}
