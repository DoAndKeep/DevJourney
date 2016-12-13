package com.doandkeep.devjourney.features.weather.presentation.di;

import com.doandkeep.devjourney.base.di.PerActivity;
import com.doandkeep.devjourney.features.weather.domain.GetWeatherDetail;
import com.doandkeep.devjourney.features.weather.domain.repository.WeatherRepository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhangtao on 2016/11/8.
 */

@Module
public class WeatherDetailModule {

    @Provides
    @PerActivity
    GetWeatherDetail provideGetWeatherUserCase(WeatherRepository weatherRepository) {
        return new GetWeatherDetail(weatherRepository);
    }

}
