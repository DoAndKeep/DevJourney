package com.doandkeep.devjourney.features.douban.movie.presentation.presenter;

import com.doandkeep.devjourney.base.domain.DefaultSubscriber;
import com.doandkeep.devjourney.base.domain.UseCase;
import com.doandkeep.devjourney.features.douban.movie.domain.GetComingSoonMovie;
import com.doandkeep.devjourney.features.douban.movie.presentation.contract.ComingSoonMovieContract;
import com.doandkeep.devjourney.features.douban.movie.presentation.model.MovieModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;


/**
 * Created by zhangtao on 2016/11/23.
 */

public class ComingSoonMoviePresenter implements ComingSoonMovieContract.Presenter {

    private final ComingSoonMovieContract.View mComingSoonMovieView;
    private final UseCase mUseCase;

    @Inject
    public ComingSoonMoviePresenter(ComingSoonMovieContract.View comingSoonMovieView, @Named("movieComingSoon") UseCase useCase) {
        mComingSoonMovieView = comingSoonMovieView;
        mUseCase = useCase;
    }

    @Inject
    void setupListeners() {
        mComingSoonMovieView.setPresenter(this);
    }

    @Override
    public void subscribe() {
        loadMovieList();
    }

    @Override
    public void unsubscribe() {

    }

    public void refresh() {
        refreshMovieList();
    }

    private void loadMovieList() {
        mComingSoonMovieView.showLoading();
        mComingSoonMovieView.hideRetry();
        getMovieList(false);
    }

    private void refreshMovieList() {
        mComingSoonMovieView.showRefresh();
        getMovieList(true);
    }

    private void getMovieList(boolean isRefrsh) {
        if (isRefrsh) {
            mUseCase.execute(new GetComingSoonMovie.RequestValues(), new RefreshMoviesSubscriber());
        } else {
            mUseCase.execute(new GetComingSoonMovie.RequestValues(), new GetMoivesSubscriber());
        }
    }

    private final class GetMoivesSubscriber extends DefaultSubscriber<List<MovieModel>> {
        @Override
        public void onCompleted() {
            super.onCompleted();
            mComingSoonMovieView.hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mComingSoonMovieView.hideLoading();
            mComingSoonMovieView.showRetry();
            mComingSoonMovieView.showError("do with this error");
        }

        @Override
        public void onNext(List<MovieModel> movies) {
            super.onNext(movies);
            mComingSoonMovieView.showMoives(movies);
        }
    }

    private final class RefreshMoviesSubscriber extends DefaultSubscriber<List<MovieModel>> {
        @Override
        public void onCompleted() {
            super.onCompleted();
            mComingSoonMovieView.hideRefresh();
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mComingSoonMovieView.hideRefresh();
            mComingSoonMovieView.showError("do with this error");
        }

        @Override
        public void onNext(List<MovieModel> movies) {
            super.onNext(movies);
            mComingSoonMovieView.showMoives(movies);
        }
    }

}
