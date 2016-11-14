package com.doandkeep.devjourney.features.weather.presentation.di;

import com.doandkeep.devjourney.base.di.PerActivity;
import com.doandkeep.devjourney.base.di.component.ActivityComponent;
import com.doandkeep.devjourney.base.di.component.ApplicationComponent;
import com.doandkeep.devjourney.base.di.module.ActivityModule;
import com.doandkeep.devjourney.features.weather.presentation.view.WeatherFragment;

import dagger.Component;

/**
 * Created by zhangtao on 2016/11/9.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, WeatherModule.class})
public interface WeatherComponent extends ActivityComponent {
    void inject(WeatherFragment weatherFragment);
}
