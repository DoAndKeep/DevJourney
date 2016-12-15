package com.doandkeep.devjourney.features.douban.movie.presentation.di;

import com.doandkeep.devjourney.base.di.PerActivity;
import com.doandkeep.devjourney.features.douban.movie.domain.GetComingSoonMovie;
import com.doandkeep.devjourney.features.douban.movie.domain.GetInTheatersMovie;
import com.doandkeep.devjourney.features.douban.movie.domain.GetTop250Movie;
import com.doandkeep.devjourney.features.douban.movie.domain.repository.DoubanMovieRepo;

import dagger.Module;
import dagger.Provides;

/**
 * 豆瓣电影Module
 * Created by zhangtao on 2016/11/21.
 */

@Module
public class DoubanMovieModule {

    @Provides
    @PerActivity
    GetInTheatersMovie provideGetMovieInTheatersUseCase(DoubanMovieRepo doubanMovieRepo) {
        return new GetInTheatersMovie(doubanMovieRepo);
    }

    @Provides
    @PerActivity
    GetComingSoonMovie provideGetMovieComingSoonUseCase(DoubanMovieRepo doubanMovieRepo) {
        return new GetComingSoonMovie(doubanMovieRepo);
    }

    @Provides
    @PerActivity
    GetTop250Movie provideGetMovieTop250UseCase(DoubanMovieRepo doubanMovieRepo) {
        return new GetTop250Movie(doubanMovieRepo);
    }
}
