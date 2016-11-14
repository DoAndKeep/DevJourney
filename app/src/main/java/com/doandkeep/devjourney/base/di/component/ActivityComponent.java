package com.doandkeep.devjourney.base.di.component;

import android.app.Activity;

import com.doandkeep.devjourney.base.di.PerActivity;
import com.doandkeep.devjourney.base.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by zhangtao on 2016/11/8.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();
}
