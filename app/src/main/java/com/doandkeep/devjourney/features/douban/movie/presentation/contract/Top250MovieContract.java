package com.doandkeep.devjourney.features.douban.movie.presentation.contract;

import com.doandkeep.devjourney.base.presentation.BasePresenter;
import com.doandkeep.devjourney.base.presentation.LoadDataView;
import com.doandkeep.devjourney.features.douban.movie.presentation.model.MovieListModel;
import com.doandkeep.devjourney.features.douban.movie.presentation.model.MovieModel;

import java.util.List;

/**
 * Top250电影View与Presenter的约定
 * Created by zhangtao on 2016/12/12.
 */

public interface Top250MovieContract {
    interface View extends LoadDataView<Presenter> {
        void showMoives(MovieListModel movieListModel);

        void showMoreMovies(MovieListModel movieListModel);

        void showRefresh();

        void hideRefresh();

        void showLoadingMore();

        void hideLoadingMore();
    }

    interface Presenter extends BasePresenter {
        void loadMovies(int count);

        void refreshMovies(int count);

        void loadMoreMovies(int start, int count);
    }
}
