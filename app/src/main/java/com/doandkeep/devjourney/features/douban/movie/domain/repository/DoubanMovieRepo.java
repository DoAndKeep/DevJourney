package com.doandkeep.devjourney.features.douban.movie.domain.repository;

import com.doandkeep.devjourney.features.douban.movie.presentation.model.MovieModel;

import java.util.List;

import rx.Observable;

/**
 * Created by zhangtao on 2016/11/23.
 */

public interface DoubanMovieRepo {
    Observable<List<MovieModel>> movieListForInTheaters(String city);

    Observable<List<MovieModel>> movieListForComingSoon();

    Observable<List<MovieModel>> movieListForTop250();
}
