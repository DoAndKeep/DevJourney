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
            weatherModel.setCity(weather.getCity());
            weatherModel.setPinyin(weather.getPinyin());
            weatherModel.setCitycode(weather.getCitycode());
            weatherModel.setDate(weather.getDate());
            weatherModel.setTime(weather.getTime());
            weatherModel.setPostCode(weather.getPostCode());
            weatherModel.setLongitude(weather.getLongitude());
            weatherModel.setLatitude(weather.getLatitude());
            weatherModel.setWeather(weather.getWeather());
            weatherModel.setTemp(weather.getTemp());
            weatherModel.setL_tmp(weather.getL_tmp());
            weatherModel.setH_tmp(weather.getH_tmp());
            weatherModel.setWD(weather.getWD());
            weatherModel.setWS(weather.getWS());
            weatherModel.setSunrise(weather.getSunrise());
            weatherModel.setSunset(weather.getSunset());
        }
        return weatherModel;
    }

}
