package com.doandkeep.devjourney.features.douban.presentation.presenter;

import com.doandkeep.devjourney.base.domain.UseCase;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by zhangtao on 2016/11/23.
 */

public class DoubanMoviesTop250Presenter extends DoubanMovieListPresenter {


    @Inject
    public DoubanMoviesTop250Presenter(@Named("movieTop250") UseCase useCase) {
        super(useCase);
    }
}
