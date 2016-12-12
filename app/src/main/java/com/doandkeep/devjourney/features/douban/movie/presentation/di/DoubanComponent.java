package com.doandkeep.devjourney.features.douban.movie.presentation.di;

import com.doandkeep.devjourney.base.di.PerActivity;
import com.doandkeep.devjourney.base.di.component.ActivityComponent;
import com.doandkeep.devjourney.base.di.component.ApplicationComponent;
import com.doandkeep.devjourney.base.di.module.ActivityModule;
import com.doandkeep.devjourney.features.douban.movie.presentation.view.DoubanMovieActivity;

import dagger.Component;

/**
 * Created by zhangtao on 2016/11/21.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, DoubanMovieModule.class, DoubanMovieViewModule.class})
public interface DoubanComponent extends ActivityComponent {
    void inject(DoubanMovieActivity doubanMovieActivity);
}
