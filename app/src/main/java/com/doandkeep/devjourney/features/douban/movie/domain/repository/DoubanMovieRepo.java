package com.doandkeep.devjourney.features.douban.movie.domain.repository;

import com.doandkeep.devjourney.features.douban.movie.domain.GetComingSoonMovie;
import com.doandkeep.devjourney.features.douban.movie.domain.GetInTheatersMovie;
import com.doandkeep.devjourney.features.douban.movie.domain.GetTop250Movie;

import rx.Observable;

/**
 * Created by zhangtao on 2016/11/23.
 */

public interface DoubanMovieRepo {
    Observable<GetInTheatersMovie.ResponseValues> movieListForInTheaters(String city);

    Observable<GetComingSoonMovie.ResponseValues> movieListForComingSoon(int start, int count);

    Observable<GetTop250Movie.ResponseValues> movieListForTop250(int start, int count);
}
