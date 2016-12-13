package com.doandkeep.devjourney.features.weather.domain;

import com.doandkeep.devjourney.base.domain.UseCase;
import com.doandkeep.devjourney.features.weather.domain.repository.WeatherRepository;
import com.doandkeep.devjourney.features.weather.presentation.model.WeatherDetailWrapperModel;

import javax.inject.Inject;

import rx.Observable;

/**
 * 获取天气详情UseCase
 * Created by zhangtao on 2016/11/8.
 */

public class GetWeatherDetail extends UseCase<GetWeatherDetail.RequestValues, GetWeatherDetail.ResponseValues> {

    private final WeatherRepository mWeatherRepository;

    @Inject
    public GetWeatherDetail(WeatherRepository weatherRepository) {
        super();
        this.mWeatherRepository = weatherRepository;
    }

    @Override
    protected Observable buildUseCaseObservable(RequestValues requestValues) {
        return this.mWeatherRepository.weather(requestValues.getCityName());
    }

    public static class RequestValues implements UseCase.RequestValues {

        private final String mCityName;

        public RequestValues(String cityName) {
            mCityName = cityName;
        }

        public String getCityName() {
            return mCityName;
        }

    }

    public static class ResponseValues implements UseCase.ResponseValues {

        private final WeatherDetailWrapperModel mWeatherDetailWrapperModel;

        public ResponseValues(WeatherDetailWrapperModel weatherDetailWrapperModel) {
            mWeatherDetailWrapperModel = weatherDetailWrapperModel;

        }

        public WeatherDetailWrapperModel getWeatherDetailWrapperModel() {
            return mWeatherDetailWrapperModel;
        }
    }
}
