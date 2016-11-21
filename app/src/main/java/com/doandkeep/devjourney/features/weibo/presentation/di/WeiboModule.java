package com.doandkeep.devjourney.features.weibo.presentation.di;

import android.app.Activity;

import com.doandkeep.devjourney.base.di.PerActivity;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.sso.SsoHandler;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhangtao on 2016/11/21.
 */

@Module
public class WeiboModule {

    private String appKey;
    private String redirectUrl;
    private String scope;

    public WeiboModule() {

    }

    public WeiboModule(String appKey, String redirectUrl, String scope) {
        this.appKey = appKey;
        this.redirectUrl = redirectUrl;
        this.scope = scope;
    }

    @Provides
    @PerActivity
    AuthInfo provideAuthInfo(Activity activity) {
        return new AuthInfo(activity, appKey, redirectUrl, scope);
    }

    @Provides
    @PerActivity
    SsoHandler provideSsoHandler(Activity activity, AuthInfo authInfo) {
        return new SsoHandler(activity, authInfo);
    }
}
