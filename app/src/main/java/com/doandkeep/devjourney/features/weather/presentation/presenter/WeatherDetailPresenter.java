package com.doandkeep.devjourney.features.weather.presentation.presenter;

import com.doandkeep.devjourney.base.domain.UseCase;
import com.doandkeep.devjourney.base.presentation.ErrorModel;
import com.doandkeep.devjourney.features.weather.domain.GetWeatherDetail;
import com.doandkeep.devjourney.features.weather.presentation.WeatherDetailContract;

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
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        mGetWeatherDetail.cancel();
    }

    @Override
    public void loadWeatherDetail(String cityName) {
        mWeatherDetailView.showLoading();
        mWeatherDetailView.hideRetry();
        mGetWeatherDetail.execute(new GetWeatherDetail.RequestValues(cityName), new UseCase.UseCaseCallback<GetWeatherDetail.ResponseValues>() {
            @Override
            public void onSuccess(GetWeatherDetail.ResponseValues response) {
                mWeatherDetailView.hideLoading();
                mWeatherDetailView.showWeatherDetail(response.getWeatherDetailWrapperModel().getRetData());
            }

            @Override
            public void onError(ErrorModel errorModel) {
                mWeatherDetailView.hideLoading();
                mWeatherDetailView.showError(errorModel.getMessage());
                mWeatherDetailView.showRetry();
            }
        });
    }
}
