package com.doandkeep.devjourney.features.douban.movie.presentation.presenter;

import com.doandkeep.devjourney.base.domain.UseCase;
import com.doandkeep.devjourney.base.presentation.ErrorModel;
import com.doandkeep.devjourney.features.douban.movie.domain.GetTop250Movie;
import com.doandkeep.devjourney.features.douban.movie.presentation.contract.Top250MovieContract;

import javax.inject.Inject;


/**
 * 获取Top250电影Presenter
 * Created by zhangtao on 2016/11/23.
 */

public class Top250MoviePresenter implements Top250MovieContract.Presenter {

    private final Top250MovieContract.View mTop250MovieView;
    private final GetTop250Movie mGetTop250Movie;

    @Inject
    public Top250MoviePresenter(Top250MovieContract.View top250MovieView, GetTop250Movie getTop250Movie) {
        mTop250MovieView = top250MovieView;
        mGetTop250Movie = getTop250Movie;
    }

    @Inject
    void setupListeners() {
        mTop250MovieView.setPresenter(this);
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        mGetTop250Movie.cancel();
    }

    @Override
    public void loadMovies(int count) {
        mTop250MovieView.showLoading();
        mTop250MovieView.hideRetry();
        mGetTop250Movie.execute(new GetTop250Movie.RequestValues(0, count), new UseCase.UseCaseCallback<GetTop250Movie.ResponseValues>() {
            @Override
            public void onSuccess(GetTop250Movie.ResponseValues response) {
                mTop250MovieView.hideLoading();
                mTop250MovieView.showMoives(response.getMovieListModel());
            }

            @Override
            public void onError(ErrorModel errorModel) {
                mTop250MovieView.hideLoading();
                mTop250MovieView.showRetry();
                mTop250MovieView.showError(errorModel.getMessage());
            }
        });
    }

    @Override
    public void refreshMovies(int count) {
        mTop250MovieView.showRefresh();
        mGetTop250Movie.execute(new GetTop250Movie.RequestValues(0, count), new UseCase.UseCaseCallback<GetTop250Movie.ResponseValues>() {
            @Override
            public void onSuccess(GetTop250Movie.ResponseValues response) {
                mTop250MovieView.hideRefresh();
                mTop250MovieView.showMoives(response.getMovieListModel());
            }

            @Override
            public void onError(ErrorModel errorModel) {
                mTop250MovieView.hideRefresh();
                mTop250MovieView.showError(errorModel.getMessage());
            }
        });
    }

    @Override
    public void loadMoreMovies(int start, int count) {
        mTop250MovieView.showLoadingMore();
        mGetTop250Movie.execute(new GetTop250Movie.RequestValues(start, count), new UseCase.UseCaseCallback<GetTop250Movie.ResponseValues>() {
            @Override
            public void onSuccess(GetTop250Movie.ResponseValues response) {
                mTop250MovieView.hideLoadingMore();
                mTop250MovieView.showMoreMovies(response.getMovieListModel());
            }

            @Override
            public void onError(ErrorModel errorModel) {
                mTop250MovieView.hideLoadingMore();
                mTop250MovieView.showError(errorModel.getMessage());
            }
        });
    }

}
