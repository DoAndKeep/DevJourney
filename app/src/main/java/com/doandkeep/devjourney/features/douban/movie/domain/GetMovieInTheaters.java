package com.doandkeep.devjourney.features.douban.movie.domain;

import com.doandkeep.devjourney.base.domain.UseCase;
import com.doandkeep.devjourney.features.douban.movie.domain.repository.DoubanMovieRepo;

import rx.Observable;

/**
 * Created by zhangtao on 2016/11/24.
 */

public class GetMovieInTheaters extends UseCase<GetMovieInTheaters.RequestValues, GetMovieInTheaters.ResponseValues> {

    private DoubanMovieRepo mDoubanMovieRepo;

    public GetMovieInTheaters(DoubanMovieRepo doubanMovieRepo) {
        this.mDoubanMovieRepo = doubanMovieRepo;
    }

    @Override
    protected Observable buildUseCaseObservable(RequestValues requestValues) {
        return this.mDoubanMovieRepo.movieListForInTheaters("北京");
    }

    public static class RequestValues implements UseCase.RequestValues {
    }

    public static class ResponseValues implements UseCase.ResponseValues {

    }
}
