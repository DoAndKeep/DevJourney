package com.doandkeep.devjourney.features.douban.movie.data.repository;

import com.doandkeep.devjourney.base.data.ServiceGenerator;
import com.doandkeep.devjourney.features.douban.movie.data.DoubanService;
import com.doandkeep.devjourney.features.douban.movie.presentation.model.MovieModel;
import com.doandkeep.devjourney.features.douban.movie.presentation.model.MovieListModel;
import com.doandkeep.devjourney.features.douban.movie.domain.repository.DoubanMovieRepo;

import java.util.List;

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
    public Observable<List<MovieModel>> movieListForInTheaters(String city) {
        return ServiceGenerator.createService(DoubanService.class).movieForInTheaters(city).map(new Func1<MovieListModel, List<MovieModel>>() {
            @Override
            public List<MovieModel> call(MovieListModel doubanMovieListEntity) {
                return doubanMovieListEntity.getSubjects();
            }
        });
    }

    @Override
    public Observable<List<MovieModel>> movieListForComingSoon() {
        return ServiceGenerator.createService(DoubanService.class).movieForComingSoon().map(new Func1<MovieListModel, List<MovieModel>>() {
            @Override
            public List<MovieModel> call(MovieListModel doubanMovieListEntity) {
                return doubanMovieListEntity.getSubjects();
            }
        });
    }

    @Override
    public Observable<List<MovieModel>> movieListForTop250() {
        return ServiceGenerator.createService(DoubanService.class).movieForTop250().map(new Func1<MovieListModel, List<MovieModel>>() {
            @Override
            public List<MovieModel> call(MovieListModel doubanMovieListEntity) {
                return doubanMovieListEntity.getSubjects();
            }
        });
    }
}
