package com.doandkeep.devjourney.features.douban.presentation.di;

import com.doandkeep.devjourney.base.di.PerActivity;
import com.doandkeep.devjourney.base.domain.UseCase;
import com.doandkeep.devjourney.features.douban.domain.GetMovieInTheatersUseCase;
import com.doandkeep.devjourney.features.douban.domain.repository.DoubanMovieRepo;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhangtao on 2016/11/21.
 */

@Module
public class DoubanModule {

    private String mCity;

    public DoubanModule(String city) {
        this.mCity = city;
    }

    @Provides
    @PerActivity
    @Named("movieInTheaters")
    UseCase provideGetMovieInTheatersUseCase(DoubanMovieRepo doubanMovieRepo) {
        return new GetMovieInTheatersUseCase(doubanMovieRepo, mCity);
    }
}
