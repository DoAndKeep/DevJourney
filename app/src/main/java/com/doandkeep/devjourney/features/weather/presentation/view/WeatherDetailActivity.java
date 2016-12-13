package com.doandkeep.devjourney.features.weather.presentation.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.doandkeep.devjourney.R;
import com.doandkeep.devjourney.base.presentation.BaseActvity;
import com.doandkeep.devjourney.features.weather.presentation.di.DaggerWeatherDetailComponent;
import com.doandkeep.devjourney.features.weather.presentation.di.WeatherDetailModule;
import com.doandkeep.devjourney.features.weather.presentation.di.WeatherDetailPresenterModule;
import com.doandkeep.devjourney.features.weather.presentation.presenter.WeatherDetailPresenter;
import com.doandkeep.devjourney.util.ActivityUtils;
import com.doandkeep.devjourney.util.view.ToolbarHelper;

import javax.inject.Inject;

/**
 * 天气详情Activity
 * Created by zhangtao on 2016/11/9.
 */

public class WeatherDetailActivity extends BaseActvity {

    @Inject
    WeatherDetailPresenter mWeatherDetailPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WeatherDetailFragment weatherDetailFragment = (WeatherDetailFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_container_layout);

        if (weatherDetailFragment == null) {
            weatherDetailFragment = WeatherDetailFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), weatherDetailFragment,
                    R.id.fragment_container_layout);
        }

        DaggerWeatherDetailComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .weatherDetailModule(new WeatherDetailModule())
                .weatherDetailPresenterModule(new WeatherDetailPresenterModule(weatherDetailFragment))
                .build().inject(this);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_layout;
    }

    @Override
    protected void initToolbar(ToolbarHelper toolbarHelper) {
        toolbarHelper.setTitle("天气");
    }

}
