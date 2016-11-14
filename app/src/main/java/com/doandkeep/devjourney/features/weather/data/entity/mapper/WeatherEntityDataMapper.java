package com.doandkeep.devjourney.features.weather.data.entity.mapper;

import com.doandkeep.devjourney.features.weather.data.entity.WeatherEntity;
import com.doandkeep.devjourney.features.weather.domain.bean.Weather;

import javax.inject.Inject;

/**
 * Created by zhangtao on 2016/11/8.
 */
public class WeatherEntityDataMapper {

    @Inject
    public WeatherEntityDataMapper() {

    }

    public Weather transform(WeatherEntity weatherEntity) {
        Weather weather = null;
        if (weatherEntity != null) {
            weather = new Weather();
            weather.setWeather(weatherEntity.getWeather());
        }
        return weather;
    }
}
