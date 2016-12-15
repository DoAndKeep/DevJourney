package com.doandkeep.devjourney.features.douban.movie.presentation.presenter;

import com.doandkeep.devjourney.base.domain.UseCase;
import com.doandkeep.devjourney.base.presentation.ErrorModel;
import com.doandkeep.devjourney.features.douban.movie.domain.GetInTheatersMovie;
import com.doandkeep.devjourney.features.douban.movie.presentation.contract.InTheatersMovieContract;

import javax.inject.Inject;

/**
 * 正在热映电影Presenter
 * Created by zhangtao on 2016/11/23.
 */

public class InTheatersMoviePresenter implements InTheatersMovieContract.Presenter {

    private final InTheatersMovieContract.View mInTheatersMovieView;
    private final GetInTheatersMovie mGetInTheatersMovie;

    @Inject
    public InTheatersMoviePresenter(InTheatersMovieContract.View inTheatersMovieView, GetInTheatersMovie getInTheatersMovie) {
        mInTheatersMovieView = inTheatersMovieView;
        mGetInTheatersMovie = getInTheatersMovie;
    }

    @Inject
    void setupListeners() {
        mInTheatersMovieView.setPresenter(this);
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        mGetInTheatersMovie.cancel();
    }

    @Override
    public void loadMovies(String city) {
        mInTheatersMovieView.showLoading();
        mInTheatersMovieView.hideRetry();
        mGetInTheatersMovie.execute(new GetInTheatersMovie.RequestValues(city), new UseCase.UseCaseCallback<GetInTheatersMovie.ResponseValues>() {
            @Override
            public void onSuccess(GetInTheatersMovie.ResponseValues response) {
                mInTheatersMovieView.hideLoading();
                mInTheatersMovieView.showMoives(response.getMovieListModel());
            }

            @Override
            public void onError(ErrorModel errorModel) {
                mInTheatersMovieView.hideLoading();
                mInTheatersMovieView.showRetry();
                mInTheatersMovieView.showError(errorModel.getMessage());
            }
        });
    }

    @Override
    public void refreshMovies(String city) {
        mInTheatersMovieView.showRefresh();
        mGetInTheatersMovie.execute(new GetInTheatersMovie.RequestValues(city), new UseCase.UseCaseCallback<GetInTheatersMovie.ResponseValues>() {
            @Override
            public void onSuccess(GetInTheatersMovie.ResponseValues response) {
                mInTheatersMovieView.hideRefresh();
                mInTheatersMovieView.showMoives(response.getMovieListModel());
            }

            @Override
            public void onError(ErrorModel errorModel) {
                mInTheatersMovieView.hideRefresh();
                mInTheatersMovieView.showError(errorModel.getMessage());
            }
        });
    }
}
