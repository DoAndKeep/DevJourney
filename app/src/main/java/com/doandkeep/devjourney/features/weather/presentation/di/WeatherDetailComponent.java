package com.doandkeep.devjourney.features.weather.presentation.di;

import com.doandkeep.devjourney.base.di.PerActivity;
import com.doandkeep.devjourney.base.di.component.ActivityComponent;
import com.doandkeep.devjourney.base.di.component.ApplicationComponent;
import com.doandkeep.devjourney.base.di.module.ActivityModule;
import com.doandkeep.devjourney.features.weather.presentation.view.WeatherDetailActivity;

import dagger.Component;

/**
 * Created by zhangtao on 2016/11/9.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, WeatherDetailModule.class, WeatherDetailPresenterModule.class})
public interface WeatherDetailComponent extends ActivityComponent {
    void inject(WeatherDetailActivity weatherDetailActivity);
}
