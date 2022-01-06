package org.itstep.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;
import org.itstep.main.weatherapi.dto.WeatherWADto;
import org.itstep.main.weatherapi.weather.ForecastDay;
import org.itstep.mapper.WeatherMapper;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

@Data
public class WeatherProviderWeatherAPI implements WeatherProvider {
    private String key = "d9c1c6f44d6e4ac589384450220501";
    private String href;
    private String name = "dnipropetrovsk";

    @SneakyThrows
    @Override
    public WeatherMapper getWeatherOnThisDay() {
        href = "http://api.weatherapi.com/v1/forecast.json?lang=ru&key=" + key + "&q=" + name + "&days=1";
        ObjectMapper mapper = new ObjectMapper();
        WeatherWADto dto = mapper.readValue(getWeather(href), WeatherWADto.class);
        WeatherMapper weatherMapper = new WeatherMapper(dto.getLocation().getName(), dto.getCurrent().getWind_mph(),
                dto.getCurrent().getTemp_c(), dto.getCurrent().getCondition().getText(), dto.getCurrent().getCondition().getIcon());
        weatherMapper.setSunset(dto.getForecast().getForecastday()[0].getAstro().getSunset());
        weatherMapper.setSunrise(dto.getForecast().getForecastday()[0].getAstro().getSunrise());
        System.out.println(weatherMapper);
        return weatherMapper;
    }

    @SneakyThrows
    @Override
    public List<WeatherMapper> getWeatherForWeek() {
        href = "http://api.weatherapi.com/v1/forecast.json?lang=ru&key=" + key + "&q=" + name + "&days=7";
        ObjectMapper mapper = new ObjectMapper();
        WeatherWADto dto = mapper.readValue(getWeather(href), WeatherWADto.class);
        System.out.println(dto);
        ArrayList<WeatherMapper> weatherList = new ArrayList<>();
        for (ForecastDay day : dto.getForecast().getForecastday()) {
            WeatherMapper weatherMapper = new WeatherMapper(dto.getLocation().getName(),
                    day.getDay().getAvgvis_miles(), day.getDay().getAvgtemp_c(),
                    day.getDay().getCondition().getText(),
                    day.getDay().getCondition().getIcon());
            weatherMapper.setDate(day.getDate());
            weatherList.add(weatherMapper);
        }
        return weatherList;
    }

    @Override
    public void setCountryName(String name) {
        this.name = name;
    }


    @SneakyThrows
    private InputStream getWeather(String href) {
        URL url = new URL(href);
        URLConnection request = url.openConnection();
        request.connect();
        return request.getInputStream();
    }
}
