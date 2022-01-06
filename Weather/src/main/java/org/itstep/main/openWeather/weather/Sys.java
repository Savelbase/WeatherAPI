package org.itstep.main.openWeather.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class Sys {
    String country ;
    long sunrise ;
    long sunset ;

    public String getSunriseString() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date(sunrise*1000));
    }

    public String getSunsetString() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date(sunset*1000));
    }
}
