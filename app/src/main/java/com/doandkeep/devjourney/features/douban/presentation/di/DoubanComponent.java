package com.doandkeep.devjourney.features.douban.presentation.di;

import com.doandkeep.devjourney.base.di.PerActivity;
import com.doandkeep.devjourney.base.di.component.ActivityComponent;
import com.doandkeep.devjourney.base.di.component.ApplicationComponent;
import com.doandkeep.devjourney.base.di.module.ActivityModule;
import com.doandkeep.devjourney.features.douban.presentation.view.movie.DoubanMovieListFragment;
import com.doandkeep.devjourney.features.douban.presentation.view.movie.DoubanMoviesComingSoonFragment;
import com.doandkeep.devjourney.features.douban.presentation.view.movie.DoubanMoviesInTheatersFragment;
import com.doandkeep.devjourney.features.douban.presentation.view.movie.DoubanMoviesTop250Fragment;

import dagger.Component;

/**
 * Created by zhangtao on 2016/11/21.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, DoubanModule.class})
public interface DoubanComponent extends ActivityComponent {
    void inject(DoubanMoviesInTheatersFragment doubanMoviesInTheatersFragment);

    void inject(DoubanMoviesComingSoonFragment doubanMoviesComingSoonFragment);

    void inject(DoubanMoviesTop250Fragment doubanMoviesTop250Fragment);
}
