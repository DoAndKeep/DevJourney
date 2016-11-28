package com.doandkeep.devjourney.features.douban.presentation.view.movie;

import android.os.Bundle;

import com.doandkeep.devjourney.features.douban.presentation.di.DoubanComponent;
import com.doandkeep.devjourney.features.douban.presentation.presenter.DoubanMovieListPresenter;
import com.doandkeep.devjourney.features.douban.presentation.presenter.DoubanMoviesComingSoonPresenter;

import javax.inject.Inject;

/**
 * Created by zhangtao on 16/8/3.
 */
public class DoubanMoviesComingSoonFragment extends DoubanMovieListFragment {

    @Inject
    DoubanMoviesComingSoonPresenter mComingSoonMoviesPresenter;

    public DoubanMoviesComingSoonFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(DoubanComponent.class).inject(this);
    }

    @Override
    protected DoubanMovieListPresenter getMovieListPresenter() {
        return mComingSoonMoviesPresenter;
    }
}
