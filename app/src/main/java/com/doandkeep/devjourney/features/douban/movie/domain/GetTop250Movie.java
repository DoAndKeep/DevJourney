package com.doandkeep.devjourney.features.douban.movie.domain;

import com.doandkeep.devjourney.base.domain.UseCase;
import com.doandkeep.devjourney.features.douban.movie.domain.repository.DoubanMovieRepo;

import rx.Observable;

/**
 * Created by zhangtao on 2016/11/24.
 */

public class GetTop250Movie extends UseCase<GetTop250Movie.RequestValues, GetTop250Movie.ResponseValues> {

    private DoubanMovieRepo mDoubanMovieRepo;

    public GetTop250Movie(DoubanMovieRepo doubanMovieRepo) {
        this.mDoubanMovieRepo = doubanMovieRepo;
    }

    @Override
    protected Observable buildUseCaseObservable(RequestValues requestValues) {
        return this.mDoubanMovieRepo.movieListForTop250();
    }

    public static final class RequestValues implements UseCase.RequestValues {
    }

    public static final class ResponseValues implements UseCase.ResponseValues {

    }
}
