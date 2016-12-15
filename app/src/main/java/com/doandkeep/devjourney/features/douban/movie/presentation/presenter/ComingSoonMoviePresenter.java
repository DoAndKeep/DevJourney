package com.doandkeep.devjourney.features.douban.movie.presentation.presenter;

import com.doandkeep.devjourney.base.domain.UseCase;
import com.doandkeep.devjourney.base.presentation.ErrorModel;
import com.doandkeep.devjourney.features.douban.movie.domain.GetComingSoonMovie;
import com.doandkeep.devjourney.features.douban.movie.presentation.contract.ComingSoonMovieContract;

import javax.inject.Inject;


/**
 * 即将上映电影Presenter
 * Created by zhangtao on 2016/11/23.
 */

public class ComingSoonMoviePresenter implements ComingSoonMovieContract.Presenter {

    private final ComingSoonMovieContract.View mComingSoonMovieView;
    private final GetComingSoonMovie mGetComingSoonMovie;

    @Inject
    public ComingSoonMoviePresenter(ComingSoonMovieContract.View comingSoonMovieView, GetComingSoonMovie getComingSoonMovie) {
        mComingSoonMovieView = comingSoonMovieView;
        mGetComingSoonMovie = getComingSoonMovie;
    }

    @Inject
    void setupListeners() {
        mComingSoonMovieView.setPresenter(this);
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        mGetComingSoonMovie.cancel();
    }

    @Override
    public void loadMovies(int count) {
        mComingSoonMovieView.showLoading();
        mComingSoonMovieView.hideRetry();
        mGetComingSoonMovie.execute(new GetComingSoonMovie.RequestValues(0, count), new UseCase.UseCaseCallback<GetComingSoonMovie.ResponseValues>() {
            @Override
            public void onSuccess(GetComingSoonMovie.ResponseValues response) {
                mComingSoonMovieView.hideLoading();
                mComingSoonMovieView.showMoives(response.getMovieListModel());
            }

            @Override
            public void onError(ErrorModel errorModel) {
                mComingSoonMovieView.hideLoading();
                mComingSoonMovieView.showRetry();
                mComingSoonMovieView.showError(errorModel.getMessage());
            }
        });
    }

    @Override
    public void refreshMovies(int count) {
        mComingSoonMovieView.showRefresh();
        mGetComingSoonMovie.execute(new GetComingSoonMovie.RequestValues(0, count), new UseCase.UseCaseCallback<GetComingSoonMovie.ResponseValues>() {
            @Override
            public void onSuccess(GetComingSoonMovie.ResponseValues response) {
                mComingSoonMovieView.hideRefresh();
                mComingSoonMovieView.showMoives(response.getMovieListModel());
            }

            @Override
            public void onError(ErrorModel errorModel) {
                mComingSoonMovieView.hideRefresh();
                mComingSoonMovieView.showError(errorModel.getMessage());
            }
        });
    }

    @Override
    public void loadMoreMovies(int start, int count) {
        mComingSoonMovieView.showLoadingMore();
        mGetComingSoonMovie.execute(new GetComingSoonMovie.RequestValues(start, count), new UseCase.UseCaseCallback<GetComingSoonMovie.ResponseValues>() {
            @Override
            public void onSuccess(GetComingSoonMovie.ResponseValues response) {
                mComingSoonMovieView.hideLoadingMore();
                mComingSoonMovieView.showMoreMovies(response.getMovieListModel());
            }

            @Override
            public void onError(ErrorModel errorModel) {
                mComingSoonMovieView.hideLoadingMore();
                mComingSoonMovieView.showError(errorModel.getMessage());
            }
        });
    }
}
