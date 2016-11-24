package com.doandkeep.devjourney.features.douban.data.repository;

import com.doandkeep.devjourney.base.ServiceGenerator;
import com.doandkeep.devjourney.features.douban.data.DoubanService;
import com.doandkeep.devjourney.features.douban.data.entity.DoubanMovieEntity;
import com.doandkeep.devjourney.features.douban.data.entity.DoubanMovieListEntity;
import com.doandkeep.devjourney.features.douban.domain.repository.DoubanMovieRepo;

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
    public Observable<List<DoubanMovieEntity>> movieListForInTheaters(String city) {
        return ServiceGenerator.createService(DoubanService.class).movieForInTheaters(city).map(new Func1<DoubanMovieListEntity, List<DoubanMovieEntity>>() {
            @Override
            public List<DoubanMovieEntity> call(DoubanMovieListEntity doubanMovieListEntity) {
                return doubanMovieListEntity.getSubjects();
            }
        });
    }
}
