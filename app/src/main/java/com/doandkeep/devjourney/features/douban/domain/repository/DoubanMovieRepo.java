package com.doandkeep.devjourney.features.douban.domain.repository;

import com.doandkeep.devjourney.features.douban.data.entity.DoubanMovieEntity;

import java.util.List;

import rx.Observable;

/**
 * Created by zhangtao on 2016/11/23.
 */

public interface DoubanMovieRepo {
    Observable<List<DoubanMovieEntity>> movieListForInTheaters(String city);

    Observable<List<DoubanMovieEntity>> movieListForComingSoon(String city);

    Observable<List<DoubanMovieEntity>> movieListForTop250(String city);
}
