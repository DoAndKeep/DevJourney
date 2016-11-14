package com.doandkeep.devjourney;

import android.app.Application;

import com.doandkeep.devjourney.base.di.component.ApplicationComponent;
import com.doandkeep.devjourney.base.di.component.DaggerApplicationComponent;
import com.doandkeep.devjourney.base.di.module.ApplicationModule;
import com.facebook.stetho.Stetho;

import timber.log.Timber;

/**
 * Created by zhangtao on 16/8/12.
 */
public class AndroidApplication extends Application {

    private static AndroidApplication mApplication;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplication = this;

        initInjector();

        Timber.plant(new Timber.DebugTree());

        Timber.e("Android Application onCreate invoked!");

        Stetho.initializeWithDefaults(this);
    }

    private void initInjector() {
        this.mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.mApplicationComponent;
    }

    public static AndroidApplication getInstance() {
        return mApplication;
    }


}
