package com.doandkeep.devjourney.features.weather.data.repository;

import com.doandkeep.devjourney.features.weather.data.entity.WeatherWrapperEntity;
import com.doandkeep.devjourney.features.weather.data.entity.mapper.WeatherEntityDataMapper;
import com.doandkeep.devjourney.features.weather.domain.bean.Weather;
import com.doandkeep.devjourney.features.weather.domain.repository.WeatherRepository;
import com.doandkeep.devjourney.base.ServiceGenerator;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by zhangtao on 2016/11/8.
 */
@Singleton
public class WeatherDataRepository implements WeatherRepository {

    private final WeatherEntityDataMapper mWeatherEntityDataMapper;

    @Inject
    public WeatherDataRepository(WeatherEntityDataMapper weatherEntityDataMapper) {
        this.mWeatherEntityDataMapper = weatherEntityDataMapper;
    }

    @Override
    public Observable<Weather> weather(String url, String cityName) {
        return ServiceGenerator.createService(WeatherService.class).weather(url, cityName).map(new Func1<WeatherWrapperEntity, Weather>() {
            @Override
            public Weather call(WeatherWrapperEntity weatherWrapperEntity) {
                return mWeatherEntityDataMapper.transform(weatherWrapperEntity.getRetData());
            }
        });
    }
}
