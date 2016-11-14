package com.doandkeep.devjourney.features.weather.presentation.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.doandkeep.devjourney.R;
import com.doandkeep.devjourney.base.di.HasComponent;
import com.doandkeep.devjourney.base.presentation.BaseActvity;
import com.doandkeep.devjourney.features.weather.presentation.di.DaggerWeatherComponent;
import com.doandkeep.devjourney.features.weather.presentation.di.WeatherComponent;
import com.doandkeep.devjourney.features.weather.presentation.di.WeatherModule;
import com.doandkeep.devjourney.util.view.ToolbarHelper;

import timber.log.Timber;

/**
 * Created by zhangtao on 2016/11/9.
 */

public class WeatherActivity extends BaseActvity implements HasComponent<WeatherComponent> {

    private WeatherComponent mWeatherComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.initActivity(savedInstanceState);
        this.initInjector();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Timber.e("onResume");
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_layout;
    }

    @Override
    protected void initToolbar(ToolbarHelper toolbarHelper) {
        toolbarHelper.setTitle("天气");
    }

    private void initActivity(Bundle savedInstanceState) {
        Timber.i("initActivity");
        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container_layout, new WeatherFragment());
        }
    }

    private void initInjector() {
        mWeatherComponent = DaggerWeatherComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .weatherModule(new WeatherModule("http://apis.baidu.com/apistore/weatherservice/weather", "北京"))
                .build();
    }

    @Override
    public WeatherComponent getComponent() {
        return mWeatherComponent;
    }
}
