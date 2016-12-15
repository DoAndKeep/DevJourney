package com.doandkeep.devjourney.features.douban.movie.presentation.contract;

import com.doandkeep.devjourney.base.presentation.BasePresenter;
import com.doandkeep.devjourney.base.presentation.LoadDataView;
import com.doandkeep.devjourney.features.douban.movie.presentation.model.MovieListModel;
import com.doandkeep.devjourney.features.douban.movie.presentation.model.MovieModel;

import java.util.List;

/**
 * 正在热映电影View与Presenter的约定
 * Created by zhangtao on 2016/12/12.
 */

public interface InTheatersMovieContract {
    interface View extends LoadDataView<Presenter> {
        void showMoives(MovieListModel movieListModel);

        void showRefresh();

        void hideRefresh();
    }

    interface Presenter extends BasePresenter {
        void loadMovies(String city);

        void refreshMovies(String city);
    }
}
