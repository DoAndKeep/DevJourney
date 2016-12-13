package com.doandkeep.devjourney.features.weather.data;

import com.doandkeep.devjourney.features.weather.domain.GetWeatherDetail;
import com.doandkeep.devjourney.features.weather.presentation.model.WeatherDetailWrapperModel;
import com.doandkeep.devjourney.features.weather.domain.repository.WeatherRepository;
import com.doandkeep.devjourney.base.data.ServiceGenerator;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by zhangtao on 2016/11/8.
 */
@Singleton
public class WeatherDataRepository implements WeatherRepository {

    @Inject
    public WeatherDataRepository() {
    }

    @Override
    public Observable<GetWeatherDetail.ResponseValues> weather(String cityName) {
        return ServiceGenerator.createService(WeatherService.class).weather(WeatherService.URL_WEATHER_DETAIL, cityName).map(new Func1<WeatherDetailWrapperModel, GetWeatherDetail.ResponseValues>() {
            @Override
            public GetWeatherDetail.ResponseValues call(WeatherDetailWrapperModel weatherDetailWrapperModel) {
                return new GetWeatherDetail.ResponseValues(weatherDetailWrapperModel);
            }
        });
    }
}
