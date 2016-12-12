package com.doandkeep.devjourney.features.douban.movie.presentation.di;

import com.doandkeep.devjourney.base.di.PerActivity;
import com.doandkeep.devjourney.features.douban.movie.presentation.contract.ComingSoonMovieContract;
import com.doandkeep.devjourney.features.douban.movie.presentation.contract.InTheatersMovieContract;
import com.doandkeep.devjourney.features.douban.movie.presentation.contract.Top250MovieContract;

import dagger.Module;
import dagger.Provides;

/**
 * 为Presenter提供View依赖的Dagger Module
 * Created by zhangtao on 2016/11/21.
 */
@Module
public class DoubanMovieViewModule {

    private final InTheatersMovieContract.View mInTheatersMovieView;
    private final ComingSoonMovieContract.View mComingSoonMovieView;
    private final Top250MovieContract.View mTop250MovieView;

    public DoubanMovieViewModule(InTheatersMovieContract.View inTheatersMovieView, ComingSoonMovieContract.View comingSoonMovieView,
                                 Top250MovieContract.View top250MovieView) {
        mInTheatersMovieView = inTheatersMovieView;
        mComingSoonMovieView = comingSoonMovieView;
        mTop250MovieView = top250MovieView;
    }

    @Provides
    @PerActivity
    InTheatersMovieContract.View provideGetMovieInTheatersUseCase() {
        return mInTheatersMovieView;
    }

    @Provides
    @PerActivity
    ComingSoonMovieContract.View provideGetMovieComingSoonUseCase() {
        return mComingSoonMovieView;
    }

    @Provides
    @PerActivity
    Top250MovieContract.View provideGetMovieTop250UseCase() {
        return mTop250MovieView;
    }
}
