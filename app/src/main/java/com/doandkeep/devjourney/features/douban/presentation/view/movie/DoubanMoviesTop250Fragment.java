package com.doandkeep.devjourney.features.douban.presentation.view.movie;

import android.os.Bundle;

import com.doandkeep.devjourney.features.douban.presentation.di.DoubanComponent;
import com.doandkeep.devjourney.features.douban.presentation.presenter.DoubanMovieListPresenter;
import com.doandkeep.devjourney.features.douban.presentation.presenter.DoubanMoviesTop250Presenter;

import javax.inject.Inject;

/**
 * Created by zhangtao on 16/8/3.
 */
public class DoubanMoviesTop250Fragment extends DoubanMovieListFragment {

    @Inject
    DoubanMoviesTop250Presenter mTop250MoviesPresenter;

    public DoubanMoviesTop250Fragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(DoubanComponent.class).inject(this);
    }

    @Override
    protected DoubanMovieListPresenter getMovieListPresenter() {
        return mTop250MoviesPresenter;
    }
}
