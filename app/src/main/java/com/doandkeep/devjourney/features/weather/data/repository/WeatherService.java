package com.doandkeep.devjourney.features.weather.data.repository;

import com.doandkeep.devjourney.features.weather.data.entity.WeatherWrapperEntity;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by zhangtao on 16/11/8.
 */
public interface WeatherService {
    @Headers("apikey:b86c2269fe6588bbe3b41924bb2f2da2")
    @GET
    Observable<WeatherWrapperEntity> weather(@Url String url, @Query("cityname") String cityName);
}
