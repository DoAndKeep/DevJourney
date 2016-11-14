package com.doandkeep.devjourney.base.di.component;

/**
 * Created by zhangtao on 2016/11/8.
 */

import android.content.Context;

import com.doandkeep.devjourney.base.presentation.BaseActvity;
import com.doandkeep.devjourney.base.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 一个component，其生命周期与应用相同
 */
@Component(modules = ApplicationModule.class)
@Singleton
public interface ApplicationComponent {
    void inject(BaseActvity baseActvity);

    // 暴露给sub-graph
    Context context();
}
