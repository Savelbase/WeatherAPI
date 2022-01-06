package org.itstep.main.openWeather.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class WeatherObject {
    private Weather [] weather ;
    private Wind wind ;
    private Main main ;
    private String dt_txt ;

    public String getDate (){
        return dt_txt.split(" ")[0];
    }
    public String getTime (){
        return dt_txt.split(" ")[1];
    }
}
