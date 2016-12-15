package com.doandkeep.devjourney.features.douban.movie.domain;

import com.doandkeep.devjourney.base.domain.UseCase;
import com.doandkeep.devjourney.features.douban.movie.domain.repository.DoubanMovieRepo;
import com.doandkeep.devjourney.features.douban.movie.presentation.model.MovieListModel;

import rx.Observable;

/**
 * 获取正在热映电影UseCase
 * Created by zhangtao on 2016/11/24.
 */

public class GetInTheatersMovie extends UseCase<GetInTheatersMovie.RequestValues, GetInTheatersMovie.ResponseValues> {

    private DoubanMovieRepo mDoubanMovieRepo;

    public GetInTheatersMovie(DoubanMovieRepo doubanMovieRepo) {
        this.mDoubanMovieRepo = doubanMovieRepo;
    }

    @Override
    protected Observable buildUseCaseObservable(RequestValues requestValues) {
        return this.mDoubanMovieRepo.movieListForInTheaters(requestValues.getCity());
    }

    public static class RequestValues implements UseCase.RequestValues {
        private final String mCity;

        public RequestValues(String city) {
            mCity = city;
        }

        public String getCity() {
            return mCity;
        }
    }

    public static class ResponseValues implements UseCase.ResponseValues {
        private final MovieListModel mMovieListModel;

        public ResponseValues(MovieListModel movieListModel) {
            mMovieListModel = movieListModel;
        }

        public MovieListModel getMovieListModel() {
            return mMovieListModel;
        }
    }
}
