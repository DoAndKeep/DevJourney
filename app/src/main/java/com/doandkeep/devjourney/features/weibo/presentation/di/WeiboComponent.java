package com.doandkeep.devjourney.features.weibo.presentation.di;

import com.doandkeep.devjourney.base.di.PerActivity;
import com.doandkeep.devjourney.base.di.component.ActivityComponent;
import com.doandkeep.devjourney.base.di.component.ApplicationComponent;
import com.doandkeep.devjourney.base.di.module.ActivityModule;
import com.doandkeep.devjourney.features.weibo.presentation.view.WeiboActivity;
import com.doandkeep.devjourney.features.weibo.presentation.view.WeiboFragment;

import dagger.Component;

/**
 * Created by zhangtao on 2016/11/21.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, WeiboModule.class})
public interface WeiboComponent extends ActivityComponent {
    void inject(WeiboFragment weiboFragment);

    void inject(WeiboActivity weiboActivity);
}
