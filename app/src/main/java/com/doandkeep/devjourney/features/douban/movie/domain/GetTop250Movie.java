package com.doandkeep.devjourney.features.douban.movie.domain;

import com.doandkeep.devjourney.base.domain.UseCase;
import com.doandkeep.devjourney.features.douban.movie.domain.repository.DoubanMovieRepo;
import com.doandkeep.devjourney.features.douban.movie.presentation.model.MovieListModel;

import rx.Observable;

/**
 * 获取Top250电影UseCase
 * Created by zhangtao on 2016/11/24.
 */

public class GetTop250Movie extends UseCase<GetTop250Movie.RequestValues, GetTop250Movie.ResponseValues> {

    private DoubanMovieRepo mDoubanMovieRepo;

    public GetTop250Movie(DoubanMovieRepo doubanMovieRepo) {
        this.mDoubanMovieRepo = doubanMovieRepo;
    }

    @Override
    protected Observable buildUseCaseObservable(RequestValues requestValues) {
        return this.mDoubanMovieRepo.movieListForTop250(requestValues.getStart(), requestValues.getCount());
    }

    public static final class RequestValues implements UseCase.RequestValues {
        private final int start;
        private final int count;

        public RequestValues(int start, int count) {
            this.start = start;
            this.count = count;
        }

        public int getStart() {
            return start;
        }

        public int getCount() {
            return count;
        }
    }

    public static final class ResponseValues implements UseCase.ResponseValues {
        private final MovieListModel mMovieListModel;

        public ResponseValues(MovieListModel movieListModel) {
            mMovieListModel = movieListModel;
        }

        public MovieListModel getMovieListModel() {
            return mMovieListModel;
        }
    }
}
