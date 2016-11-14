package com.doandkeep.devjourney.features.weather.presentation.model;

import com.doandkeep.devjourney.base.di.PerActivity;
import com.doandkeep.devjourney.features.weather.domain.bean.Weather;

import javax.inject.Inject;

/**
 * Created by zhangtao on 2016/11/9.
 */
@PerActivity
public class WeatherModelDataMapper {

    @Inject
    public WeatherModelDataMapper() {

    }

    public WeatherModel transform(Weather weather) {
        WeatherModel weatherModel = null;
        if (weather != null) {
            weatherModel = new WeatherModel();
            weatherModel.setWeather(weather.getWeather());
        }
        return weatherModel;
    }

}
