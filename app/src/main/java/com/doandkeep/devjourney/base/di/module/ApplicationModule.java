package com.doandkeep.devjourney.base.di.module;

/**
 * Created by zhangtao on 2016/11/8.
 */

import android.content.Context;

import com.doandkeep.devjourney.AndroidApplication;
import com.doandkeep.devjourney.features.douban.movie.data.repository.DoubanMovieDataRepo;
import com.doandkeep.devjourney.features.douban.movie.domain.repository.DoubanMovieRepo;
import com.doandkeep.devjourney.features.weather.data.repository.WeatherDataRepository;
import com.doandkeep.devjourney.features.weather.domain.repository.WeatherRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module，存活整个应用生命周期来提供对象。
 */
@Module
public class ApplicationModule {

    private final AndroidApplication mApplication;

    public ApplicationModule(AndroidApplication application) {
        this.mApplication = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.mApplication;
    }

    @Provides
    @Singleton
    WeatherRepository provideWeatherRepository(WeatherDataRepository weatherDataRepository) {
        return weatherDataRepository;
    }

    @Provides
    @Singleton
    DoubanMovieRepo provideDoubanMovieRepo(DoubanMovieDataRepo doubanMovieDataRepo) {
        return doubanMovieDataRepo;
    }

}
