package com.doandkeep.devjourney.features.douban.presentation.view.movie;

import android.os.Bundle;

import com.doandkeep.devjourney.features.douban.presentation.di.DoubanComponent;
import com.doandkeep.devjourney.features.douban.presentation.presenter.DoubanMoviesInTheatersPresenter;

import javax.inject.Inject;

/**
 * Created by zhangtao on 16/8/3.
 */
public class DoubanMoviesInTheatersFragment extends DoubanMovieListFragment {

    @Inject
    DoubanMoviesInTheatersPresenter mInTheatersMoviesPresenter;

    public DoubanMoviesInTheatersFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(DoubanComponent.class).inject(this);
        super.movieListPresenter = mInTheatersMoviesPresenter;
    }
}
