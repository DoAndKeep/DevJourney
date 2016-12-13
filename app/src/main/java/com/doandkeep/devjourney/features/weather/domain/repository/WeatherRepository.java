package com.doandkeep.devjourney.features.weather.domain.repository;

import com.doandkeep.devjourney.features.weather.domain.GetWeatherDetail;

import rx.Observable;

/**
 * Created by zhangtao on 2016/11/8.
 */
public interface WeatherRepository {
    Observable<GetWeatherDetail.ResponseValues> weather(String cityName);
}
