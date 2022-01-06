package org.itstep.main.openWeather.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class City {
    private String name ;
    private String country ;
    private long sunrise ;
    private long sunset ;
    public String getSunriseString() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(sunrise*1000));
    }

    public String getSunsetString() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(sunset*1000));
    }
}
