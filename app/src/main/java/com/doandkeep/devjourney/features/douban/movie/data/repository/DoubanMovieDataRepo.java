package com.doandkeep.devjourney.features.douban.movie.data.repository;

import com.doandkeep.devjourney.base.data.ServiceGenerator;
import com.doandkeep.devjourney.features.douban.movie.data.DoubanService;
import com.doandkeep.devjourney.features.douban.movie.domain.GetComingSoonMovie;
import com.doandkeep.devjourney.features.douban.movie.domain.GetInTheatersMovie;
import com.doandkeep.devjourney.features.douban.movie.domain.GetTop250Movie;
import com.doandkeep.devjourney.features.douban.movie.presentation.model.MovieListModel;
import com.doandkeep.devjourney.features.douban.movie.domain.repository.DoubanMovieRepo;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by zhangtao on 2016/11/23.
 */

public class DoubanMovieDataRepo implements DoubanMovieRepo {

    @Inject
    public DoubanMovieDataRepo() {

    }

    @Override
    public Observable<GetInTheatersMovie.ResponseValues> movieListForInTheaters(String city) {
        return ServiceGenerator.createService(DoubanService.class).movieForInTheaters(city).map(new Func1<MovieListModel, GetInTheatersMovie.ResponseValues>() {
            @Override
            public GetInTheatersMovie.ResponseValues call(MovieListModel movieListModel) {
                return new GetInTheatersMovie.ResponseValues(movieListModel);
            }
        });
    }

    @Override
    public Observable<GetComingSoonMovie.ResponseValues> movieListForComingSoon(int start, int count) {
        return ServiceGenerator.createService(DoubanService.class).movieForComingSoon(start, count).map(new Func1<MovieListModel, GetComingSoonMovie.ResponseValues>() {
            @Override
            public GetComingSoonMovie.ResponseValues call(MovieListModel movieListModel) {
                return new GetComingSoonMovie.ResponseValues(movieListModel);
            }
        });
    }

    @Override
    public Observable<GetTop250Movie.ResponseValues> movieListForTop250(int start, int count) {
        return ServiceGenerator.createService(DoubanService.class).movieForTop250(start, count).map(new Func1<MovieListModel, GetTop250Movie.ResponseValues>() {
            @Override
            public GetTop250Movie.ResponseValues call(MovieListModel movieListModel) {
                return new GetTop250Movie.ResponseValues(movieListModel);
            }
        });
    }
}
