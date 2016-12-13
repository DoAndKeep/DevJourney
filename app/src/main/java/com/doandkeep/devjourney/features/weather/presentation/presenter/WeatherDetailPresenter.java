package com.doandkeep.devjourney.features.weather.presentation.presenter;

import com.doandkeep.devjourney.base.domain.DefaultSubscriber;
import com.doandkeep.devjourney.features.weather.domain.GetWeatherDetail;
import com.doandkeep.devjourney.features.weather.presentation.WeatherDetailContract;
import com.doandkeep.devjourney.features.weather.presentation.model.WeatherDetailModel;

import javax.inject.Inject;

/**
 * 天气详情Presenter
 * Created by zhangtao on 2016/11/9.
 */
public class WeatherDetailPresenter implements WeatherDetailContract.Presenter {

    private WeatherDetailContract.View mWeatherDetailView;

    private final GetWeatherDetail mGetWeatherDetail;

    @Inject
    public WeatherDetailPresenter(WeatherDetailContract.View weatherDetailView, GetWeatherDetail getWeatherDetail) {
        this.mWeatherDetailView = weatherDetailView;
        this.mGetWeatherDetail = getWeatherDetail;
    }

    @Inject
    public void setupListeners() {
        mWeatherDetailView.setPresenter(this);
    }

    @Override
    public void loadWeatherDetail(String cityName) {
        getWeatherDetail(cityName);
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        mGetWeatherDetail.cancel();
    }

    private void getWeatherDetail(String cityName) {
        mWeatherDetailView.showLoading();
        mWeatherDetailView.hideRetry();
        getWeather(cityName);
    }

    private void getWeather(String cityName) {
        mGetWeatherDetail.execute(new GetWeatherDetail.RequestValues(cityName), new WeatherSubscriber());
    }

    private final class WeatherSubscriber extends DefaultSubscriber<GetWeatherDetail.ResponseValues> {
        @Override
        public void onCompleted() {
            mWeatherDetailView.hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            mWeatherDetailView.hideLoading();
            mWeatherDetailView.showError("to do with the error");
            mWeatherDetailView.showRetry();
        }

        @Override
        public void onNext(GetWeatherDetail.ResponseValues responseValues) {
            WeatherDetailModel weatherDetailModel = responseValues.getWeatherDetailWrapperModel().getRetData();
            if (weatherDetailModel != null) {
                mWeatherDetailView.showWeatherDetail(responseValues.getWeatherDetailWrapperModel().getRetData());
            } else {
                mWeatherDetailView.showError(responseValues.getWeatherDetailWrapperModel().getErrMsg());
                mWeatherDetailView.showRetry();
            }
        }
    }
}
