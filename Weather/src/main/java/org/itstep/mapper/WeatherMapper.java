package org.itstep.mapper;

import lombok.Data;

@Data
public class WeatherMapper {
    private String city ;
    private Double wind ;
    private Double temp ;
    private String condition ;
    private String icon ;
    private String sunrise ;
    private String sunset ;
    private String date ;

    public WeatherMapper(String city, Double wind, Double temp, String condition, String icon) {
        this.city = city;
        this.wind = wind;
        this.temp = temp;
        this.condition = condition;
        this.icon = icon;
    }
}
