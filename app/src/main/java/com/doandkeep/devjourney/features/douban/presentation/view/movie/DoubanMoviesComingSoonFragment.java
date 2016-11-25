package com.doandkeep.devjourney.features.douban.presentation.view.movie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.doandkeep.devjourney.features.douban.presentation.di.DoubanComponent;
import com.doandkeep.devjourney.features.douban.presentation.presenter.DoubanMoviesComingSoonPresenter;

import javax.inject.Inject;

/**
 * Created by zhangtao on 16/8/3.
 */
public class DoubanMoviesComingSoonFragment extends DoubanMovieListFragment {

    @Inject
    DoubanMoviesComingSoonPresenter mMovieListPresenter;

    public DoubanMoviesComingSoonFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(DoubanComponent.class).inject(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mMovieListPresenter.setView(this);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected void loadMovies() {
        super.loadMovies();
        mMovieListPresenter.init();
    }

    @Override
    protected void refreshMovies() {
        super.refreshMovies();
        mMovieListPresenter.refresh();
    }
}
