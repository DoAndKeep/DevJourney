package com.doandkeep.devjourney.features.weibo.presentation.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.doandkeep.devjourney.R;
import com.doandkeep.devjourney.base.di.HasComponent;
import com.doandkeep.devjourney.base.presentation.BaseActvity;
import com.doandkeep.devjourney.features.weibo.presentation.di.DaggerWeiboComponent;
import com.doandkeep.devjourney.features.weibo.presentation.di.WeiboComponent;
import com.doandkeep.devjourney.features.weibo.presentation.di.WeiboModule;
import com.doandkeep.devjourney.features.weibo.timeline.WeiboTimelineActivity;
import com.doandkeep.devjourney.third.weibo.AccessTokenKeeper;
import com.doandkeep.devjourney.third.weibo.Constants;
import com.doandkeep.devjourney.util.view.ToolbarHelper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by zhangtao on 16/7/15.
 */
public class WeiboActivity extends BaseActvity implements HasComponent<WeiboComponent>, WeiboFragment.WeiboListener {

    private WeiboComponent mWeiboComponent;
    /**
     * 注意：SsoHandler 仅当 SDK 支持 SSO 时有效
     */
    @Inject
    SsoHandler mSsoHandler;
    /**
     * 封装了 "access_token"，"expires_in"，"refresh_token"，并提供了他们的管理功能
     */
    private Oauth2AccessToken mAccessToken;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAccessToken = AccessTokenKeeper.readAccessToken(this);
        if (mAccessToken.isSessionValid()) {
            // 还有效
        }

        this.initActivity(savedInstanceState);
        this.initInjector();
        mWeiboComponent.inject(this);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_layout;
    }

    @Override
    protected void initToolbar(ToolbarHelper toolbarHelper) {
        toolbarHelper.setTitle("新浪微博");
    }

    /**
     * 当 SSO 授权 Activity 退出时，该函数被调用。
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Timber.e("onActivityResult");
        if (mSsoHandler != null) {
            mSsoHandler.authorizeCallBack(requestCode, resultCode, data);
        }
    }

    public void unBind() {
        AccessTokenKeeper.clear(getApplicationContext());
        mAccessToken = new Oauth2AccessToken();
    }

    @Override
    public void doBind() {
        mSsoHandler.authorize(new WeiboAuthListener() {
            @Override
            public void onComplete(Bundle values) {
                Timber.e("onComplete");
                mAccessToken = Oauth2AccessToken.parseAccessToken(values);
                if (mAccessToken.isSessionValid()) {
                    // 保存 Token 到 SharedPreferences
                    AccessTokenKeeper.writeAccessToken(WeiboActivity.this, mAccessToken);
                } else {
                    // 以下几种情况，您会收到 Code：
                    // 1. 当您未在平台上注册的应用程序的包名与签名时；
                    // 2. 当您注册的应用程序包名与签名不正确时；
                    // 3. 当您在平台上注册的包名和签名与您当前测试的应用的包名和签名不匹配时。
                    String code = values.getString("code");
                    Timber.e("onComplete: " + code);
                }
            }

            @Override
            public void onCancel() {
                Timber.e("onCancel");
            }

            @Override
            public void onWeiboException(WeiboException e) {
                Timber.e("onWeiboException");
            }
        });
    }

    @Override
    public void viewWeiboList() {
        Intent intent = new Intent(WeiboActivity.this, WeiboTimelineActivity.class);
        startActivity(intent);
    }

    @Override
    public WeiboComponent getComponent() {
        return mWeiboComponent;
    }

    private void initActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container_layout, new WeiboFragment());
        }
    }

    private void initInjector() {
        mWeiboComponent = DaggerWeiboComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .weiboModule(new WeiboModule(Constants.APP_KEY, Constants.REDIRECT_URL, Constants.SCOPE))
                .build();
    }

}
