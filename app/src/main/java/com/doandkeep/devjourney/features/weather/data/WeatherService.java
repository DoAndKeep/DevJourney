package com.doandkeep.devjourney.features.weather.data;

import com.doandkeep.devjourney.features.weather.presentation.model.WeatherDetailWrapperModel;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 *
 * http://apistore.baidu.com/apiworks/servicedetail/112.html
 * Created by zhangtao on 16/11/8.
 */
public interface WeatherService {

    /**
     * 天气详情url
     */
    String URL_WEATHER_DETAIL = "http://apis.baidu.com/apistore/weatherservice/weather";

    @Headers("apikey:b86c2269fe6588bbe3b41924bb2f2da2")
    @GET
    Observable<WeatherDetailWrapperModel> weather(@Url String url, @Query("cityname") String cityName);
}
