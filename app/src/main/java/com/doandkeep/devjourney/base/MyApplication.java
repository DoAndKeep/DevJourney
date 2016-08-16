package com.doandkeep.devjourney.base;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by zhangtao on 16/8/12.
 */
public class MyApplication extends Application {

    private static MyApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplication = this;

        Stetho.initializeWithDefaults(this);
    }

    public static MyApplication getInstance() {
        return mApplication;
    }
}
