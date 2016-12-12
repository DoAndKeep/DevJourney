package com.doandkeep.devjourney.features.douban.movie.presentation.di;

import com.doandkeep.devjourney.base.di.PerActivity;
import com.doandkeep.devjourney.base.domain.UseCase;
import com.doandkeep.devjourney.features.douban.movie.domain.GetComingSoonMovie;
import com.doandkeep.devjourney.features.douban.movie.domain.GetMovieInTheaters;
import com.doandkeep.devjourney.features.douban.movie.domain.GetTop250Movie;
import com.doandkeep.devjourney.features.douban.movie.domain.repository.DoubanMovieRepo;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhangtao on 2016/11/21.
 */

@Module
public class DoubanMovieModule {

    @Provides
    @PerActivity
    @Named("movieInTheaters")
    UseCase provideGetMovieInTheatersUseCase(DoubanMovieRepo doubanMovieRepo) {
        return new GetMovieInTheaters(doubanMovieRepo);
    }

    @Provides
    @PerActivity
    @Named("movieComingSoon")
    UseCase provideGetMovieComingSoonUseCase(DoubanMovieRepo doubanMovieRepo) {
        return new GetComingSoonMovie(doubanMovieRepo);
    }

    @Provides
    @PerActivity
    @Named("movieTop250")
    UseCase provideGetMovieTop250UseCase(DoubanMovieRepo doubanMovieRepo) {
        return new GetTop250Movie(doubanMovieRepo);
    }
}
