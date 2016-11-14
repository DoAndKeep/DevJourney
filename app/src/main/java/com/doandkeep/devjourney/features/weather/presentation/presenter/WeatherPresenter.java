package com.doandkeep.devjourney.features.weather.presentation.presenter;

import com.doandkeep.devjourney.base.domain.DefaultSubscriber;
import com.doandkeep.devjourney.base.domain.UseCase;
import com.doandkeep.devjourney.base.presentation.Presenter;
import com.doandkeep.devjourney.features.weather.domain.bean.Weather;
import com.doandkeep.devjourney.features.weather.presentation.model.WeatherModel;
import com.doandkeep.devjourney.features.weather.presentation.model.WeatherModelDataMapper;
import com.doandkeep.devjourney.features.weather.presentation.view.WeatherView;

import javax.inject.Inject;
import javax.inject.Named;

import timber.log.Timber;

/**
 * Created by zhangtao on 2016/11/9.
 */
public class WeatherPresenter implements Presenter {

    private WeatherView mWeatherView;

    private final UseCase mWeatherUseCase;
    private final WeatherModelDataMapper mWeatherModelDataMapper;

    @Inject
    public WeatherPresenter(@Named("weather") UseCase weatherUseCase, WeatherModelDataMapper weatherModelDataMapper) {
        this.mWeatherUseCase = weatherUseCase;
        this.mWeatherModelDataMapper = weatherModelDataMapper;
    }

    public void setView(WeatherView weatherView) {
        this.mWeatherView = weatherView;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        this.mWeatherUseCase.unsubscribe();
        this.mWeatherView = null;
    }

    public void init() {
        this.loadWeather();
    }

    private void loadWeather() {
        this.showLoadingView();
        this.hideRetryView();
        this.getWeather();
    }

    private void showLoadingView() {
        this.mWeatherView.showLoading();
    }

    private void hideLoadingView() {
        this.mWeatherView.hideLoading();
    }

    private void showRetryView() {
        this.mWeatherView.showRetry();
    }

    private void hideRetryView() {
        this.mWeatherView.hideRetry();
    }

    private void showErrorMessgae(String msg) {
        this.mWeatherView.showError(msg);
    }

    private void showWeatherInView(Weather weather) {
        WeatherModel weatherModel = this.mWeatherModelDataMapper.transform(weather);
        this.mWeatherView.renderWeather(weatherModel);
    }

    private void getWeather() {
        Timber.i("getWeather invoked");
        this.mWeatherUseCase.execute(new WeatherSubscriber());
    }

    private final class WeatherSubscriber extends DefaultSubscriber<Weather> {
        @Override
        public void onCompleted() {
            WeatherPresenter.this.hideLoadingView();
        }

        @Override
        public void onError(Throwable e) {
            Timber.e(e);
            WeatherPresenter.this.hideLoadingView();
            WeatherPresenter.this.showErrorMessgae("to do with the error");
            WeatherPresenter.this.showRetryView();
        }

        @Override
        public void onNext(Weather weather) {
            WeatherPresenter.this.showWeatherInView(weather);
        }
    }
}
