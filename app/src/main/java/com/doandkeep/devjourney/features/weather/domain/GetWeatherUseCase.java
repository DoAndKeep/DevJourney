package com.doandkeep.devjourney.features.weather.domain;

import com.doandkeep.devjourney.base.domain.UseCase;
import com.doandkeep.devjourney.features.weather.domain.repository.WeatherRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by zhangtao on 2016/11/8.
 */

public class GetWeatherUseCase extends UseCase {

    private final String mUrl;
    private final String mCityName;
    private final WeatherRepository mWeatherRepository;

    @Inject
    public GetWeatherUseCase(String url, String cityName, WeatherRepository weatherRepository) {
        super();
        this.mUrl = url;
        this.mCityName = cityName;
        this.mWeatherRepository = weatherRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return this.mWeatherRepository.weather(mUrl, mCityName);
    }
}
