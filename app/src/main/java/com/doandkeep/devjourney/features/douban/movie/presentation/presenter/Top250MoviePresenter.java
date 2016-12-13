package com.doandkeep.devjourney.features.douban.movie.presentation.presenter;

import com.doandkeep.devjourney.base.domain.DefaultSubscriber;
import com.doandkeep.devjourney.base.domain.UseCase;
import com.doandkeep.devjourney.features.douban.movie.domain.GetTop250Movie;
import com.doandkeep.devjourney.features.douban.movie.presentation.contract.Top250MovieContract;
import com.doandkeep.devjourney.features.douban.movie.presentation.model.MovieModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;


/**
 * Created by zhangtao on 2016/11/23.
 */

public class Top250MoviePresenter implements Top250MovieContract.Presenter {

    private final Top250MovieContract.View mTop250MovieView;
    private final UseCase mUseCase;

    @Inject
    public Top250MoviePresenter(Top250MovieContract.View top250MovieView, @Named("movieTop250") UseCase useCase) {
        mTop250MovieView = top250MovieView;
        mUseCase = useCase;
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
        loadMovieList();
    }

    public void refresh() {
        refreshMovieList();
    }

    private void loadMovieList() {
        mTop250MovieView.showLoading();
        mTop250MovieView.hideRetry();
        getMovieList(false);
    }

    private void refreshMovieList() {
        mTop250MovieView.showRefresh();
        getMovieList(true);
    }

    private void getMovieList(boolean isRefrsh) {
        if (isRefrsh) {
            mUseCase.execute(new GetTop250Movie.RequestValues(), new RefreshMoviesSubscriber());
        } else {
            mUseCase.execute(new GetTop250Movie.RequestValues(), new GetMoivesSubscriber());
        }
    }

    private final class GetMoivesSubscriber extends DefaultSubscriber<List<MovieModel>> {
        @Override
        public void onCompleted() {
            super.onCompleted();
            mTop250MovieView.hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mTop250MovieView.hideLoading();
            mTop250MovieView.showRetry();
            mTop250MovieView.showError("do with this error");
        }

        @Override
        public void onNext(List<MovieModel> movies) {
            super.onNext(movies);
            mTop250MovieView.showMoives(movies);
        }
    }

    private final class RefreshMoviesSubscriber extends DefaultSubscriber<List<MovieModel>> {
        @Override
        public void onCompleted() {
            super.onCompleted();
            mTop250MovieView.hideRefresh();
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mTop250MovieView.hideRefresh();
            mTop250MovieView.showError("do with this error");
        }

        @Override
        public void onNext(List<MovieModel> movies) {
            super.onNext(movies);
            mTop250MovieView.showMoives(movies);
        }
    }

}
