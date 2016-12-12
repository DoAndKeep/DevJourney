package com.doandkeep.devjourney.features.douban.movie.data;

import com.doandkeep.devjourney.features.douban.movie.presentation.model.MovieListModel;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by zhangtao on 16/8/5.
 */
public interface DoubanService {

    @GET("movie/in_theaters")
    Observable<MovieListModel> movieForInTheaters(@Query("city") String city);

    @GET("movie/coming_soon")
    Observable<MovieListModel> movieForComingSoon();

    @GET("movie/top250")
    Observable<MovieListModel> movieForTop250();
}
