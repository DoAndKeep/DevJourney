package com.doandkeep.devjourney.base.di.module;

import android.app.Activity;

import com.doandkeep.devjourney.base.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhangtao on 2016/11/8.
 */

@Module
public class ActivityModule {

    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @PerActivity
    @Provides
    Activity provideActivity() {
        return this.mActivity;
    }

}
