package com.doandkeep.devjourney.features.douban.movie.domain;

import com.doandkeep.devjourney.base.domain.UseCase;
import com.doandkeep.devjourney.features.douban.movie.domain.repository.DoubanMovieRepo;

import rx.Observable;

/**
 * 获取即将上映电影用例
 * Created by zhangtao on 2016/11/24.
 */

public class GetComingSoonMovie extends UseCase<GetComingSoonMovie.RequestValues, GetComingSoonMovie.ResponseValues> {

    private DoubanMovieRepo mDoubanMovieRepo;

    public GetComingSoonMovie(DoubanMovieRepo doubanMovieRepo) {
        mDoubanMovieRepo = doubanMovieRepo;
    }

    @Override
    protected Observable buildUseCaseObservable(RequestValues requestValues) {
        return mDoubanMovieRepo.movieListForComingSoon();
    }

    public static class RequestValues implements UseCase.RequestValues {

    }

    public static class ResponseValues implements UseCase.ResponseValues {

    }
}
