package org.itstep.provider;

import org.itstep.main.dto.WeatherCurrentDto;
import org.itstep.main.dto.WeatherForecastDto;
import org.itstep.mapper.WeatherMapper;

import java.util.List;

public interface WeatherProvider {
    WeatherMapper getWeatherOnThisDay();
    List<WeatherMapper> getWeatherForWeek();
    void setCountryName(String name);
}
