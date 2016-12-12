package com.doandkeep.devjourney.features.weather.presentation.di;

import com.doandkeep.devjourney.base.di.PerActivity;
import com.doandkeep.devjourney.base.domain.UseCase;
import com.doandkeep.devjourney.features.weather.domain.GetWeather;
import com.doandkeep.devjourney.features.weather.domain.repository.WeatherRepository;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger Module，提供天气相关的合作者。
 * Created by zhangtao on 2016/11/8.
 */

@Module
public class WeatherModule {

    private String mUrl;
    private String mCityName;

    public WeatherModule() {

    }

    public WeatherModule(String url, String cityName) {
        this.mUrl = url;
        this.mCityName = cityName;
    }

    @Provides
    @PerActivity
    @Named("weather")
    UseCase provideGetWeatherUserCase(WeatherRepository weatherRepository) {
        return new GetWeather(mUrl, mCityName, weatherRepository);
    }

}
