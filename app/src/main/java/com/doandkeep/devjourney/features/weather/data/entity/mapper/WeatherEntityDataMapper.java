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
            weather.setCity(weatherEntity.getCity());
            weather.setPinyin(weatherEntity.getPinyin());
            weather.setCitycode(weatherEntity.getCitycode());
            weather.setDate(weatherEntity.getDate());
            weather.setTime(weatherEntity.getTime());
            weather.setPostCode(weatherEntity.getPostCode());
            weather.setLongitude(weatherEntity.getLongitude());
            weather.setLatitude(weatherEntity.getLatitude());
            weather.setWeather(weatherEntity.getWeather());
            weather.setTemp(weatherEntity.getTemp());
            weather.setL_tmp(weatherEntity.getL_tmp());
            weather.setH_tmp(weatherEntity.getH_tmp());
            weather.setWD(weatherEntity.getWD());
            weather.setWS(weatherEntity.getWS());
            weather.setSunrise(weatherEntity.getSunrise());
            weather.setSunset(weatherEntity.getSunset());
        }
        return weather;
    }
}
