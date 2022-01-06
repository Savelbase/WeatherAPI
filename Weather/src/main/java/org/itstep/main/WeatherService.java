package org.itstep.main;

import lombok.Data;
import org.itstep.provider.WeatherProvider;

@Data
public class WeatherService {

    private WeatherProvider provider ;

}
