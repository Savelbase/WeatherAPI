package org.itstep.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;
import org.itstep.main.openWeather.dto.WeatherOpenWMDto;
import org.itstep.main.openWeather.dto.WeatherOpenWMForecast;
import org.itstep.main.openWeather.weather.WeatherObject;
import org.itstep.mapper.WeatherMapper;

import java.io.InputStream;
import java.net.*;
import java.util.ArrayList;

@Data
public class WeatherProviderOpenWeather implements WeatherProvider {
    String key = "c0108030705c034ad6c7d31599640a96";
    private String ref;
    private String country;


    @SneakyThrows
    @Override
    public WeatherMapper getWeatherOnThisDay() {
        ref = "https://api.openweathermap.org/data/2.5/weather?q=" + country + "&units=metric&lang=ru&appid=";
        ObjectMapper mapper = new ObjectMapper();
        WeatherOpenWMDto dto = mapper.readValue(getWeather(ref), WeatherOpenWMDto.class);
        WeatherMapper weatherMapper = new WeatherMapper(dto.getName(), dto.getWind().getSpeed(), dto.getMain().getTemp(),
                dto.getWeather()[0].getDescription(),
                "https://openweathermap.org/img/w/" + dto.getWeather()[0].getIcon() + ".png");
        weatherMapper.setSunrise(dto.getSys().getSunriseString());
        weatherMapper.setSunset(dto.getSys().getSunsetString());
        System.out.println(weatherMapper);
        return weatherMapper;
    }

    @SneakyThrows
    @Override
    public ArrayList<WeatherMapper> getWeatherForWeek() {
        ref = "https://api.openweathermap.org/data/2.5/forecast?q=" + country + "&units=metric&lang=ru&cnt=40&appid=";
        ObjectMapper mapper = new ObjectMapper();
        WeatherOpenWMForecast weatherForecast = mapper.readValue(getWeather(ref), WeatherOpenWMForecast.class);
        ArrayList<WeatherMapper> weatherList = new ArrayList<>();
        for (WeatherObject weatherObject : weatherForecast.getList()) {
            if (weatherObject.getTime().contains("12:00")) {
                WeatherMapper weatherMapper = new WeatherMapper(
                        weatherForecast.getCity().getName(),
                        weatherObject.getWind().getSpeed(),
                        weatherObject.getMain().getTemp(),
                        weatherObject.getWeather()[0].getDescription(),
                        "https://openweathermap.org/img/w/" + weatherObject.getWeather()[0].getIcon() + ".png"
                );
                weatherMapper.setDate(weatherObject.getDate());
                weatherList.add(weatherMapper);
            }
        }
        System.out.println(weatherList);
        return weatherList;
    }

    @Override
    public void setCountryName(String name) {
        country = name;
    }

    @SneakyThrows
    private InputStream getWeather(String href) {
        URL url = new URL(href + key);
        URLConnection request = url.openConnection();
        request.connect();
        return request.getInputStream();
    }
}
