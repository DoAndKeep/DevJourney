package com.doandkeep.devjourney.features.douban.presentation.presenter;

import com.doandkeep.devjourney.base.domain.UseCase;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by zhangtao on 2016/11/23.
 */

public class DoubanMoviesComingSoonPresenter extends DoubanMovieListPresenter {


    @Inject
    public DoubanMoviesComingSoonPresenter(@Named("movieComingSoon") UseCase useCase) {
        super(useCase);
    }
}
