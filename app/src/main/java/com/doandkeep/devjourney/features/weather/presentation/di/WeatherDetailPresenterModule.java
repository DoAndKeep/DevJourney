package com.doandkeep.devjourney.features.weather.presentation.di;

import com.doandkeep.devjourney.base.di.PerActivity;
import com.doandkeep.devjourney.features.weather.presentation.WeatherDetailContract;
import com.doandkeep.devjourney.features.weather.presentation.presenter.WeatherDetailPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * 为{@link WeatherDetailPresenter}提供View依赖的Dagger Module。
 * Created by zhangtao on 2016/11/8.
 */

@Module
public class WeatherDetailPresenterModule {

    private final WeatherDetailContract.View mView;

    public WeatherDetailPresenterModule(WeatherDetailContract.View view) {
        mView = view;
    }

    @Provides
    @PerActivity
    WeatherDetailContract.View provideWeatherDetailContractView() {
        return mView;
    }

}
