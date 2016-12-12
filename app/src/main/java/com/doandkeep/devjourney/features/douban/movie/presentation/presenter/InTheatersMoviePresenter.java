package com.doandkeep.devjourney.features.douban.movie.presentation.presenter;

import com.doandkeep.devjourney.base.domain.DefaultSubscriber;
import com.doandkeep.devjourney.base.domain.UseCase;
import com.doandkeep.devjourney.features.douban.movie.domain.GetMovieInTheaters;
import com.doandkeep.devjourney.features.douban.movie.presentation.contract.InTheatersMovieContract;
import com.doandkeep.devjourney.features.douban.movie.presentation.model.MovieModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;


/**
 * Created by zhangtao on 2016/11/23.
 */

public class InTheatersMoviePresenter implements InTheatersMovieContract.Presenter {

    private final InTheatersMovieContract.View mInTheatersMovieView;
    private final UseCase mUseCase;

    @Inject
    public InTheatersMoviePresenter(InTheatersMovieContract.View inTheatersMovieView, @Named("movieInTheaters") UseCase useCase) {
        mInTheatersMovieView = inTheatersMovieView;
        mUseCase = useCase;
    }

    @Inject
    void setupListeners() {
        mInTheatersMovieView.setPresenter(this);
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
        mInTheatersMovieView.showLoading();
        mInTheatersMovieView.hideRetry();
        getMovieList(false);
    }

    private void refreshMovieList() {
        mInTheatersMovieView.showRefresh();
        getMovieList(true);
    }

    private void getMovieList(boolean isRefrsh) {
        if (isRefrsh) {
            mUseCase.execute(new GetMovieInTheaters.RequestValues(), new RefreshMoviesSubscriber());
        } else {
            mUseCase.execute(new GetMovieInTheaters.RequestValues(), new GetMoivesSubscriber());
        }
    }

    private final class GetMoivesSubscriber extends DefaultSubscriber<List<MovieModel>> {
        @Override
        public void onCompleted() {
            super.onCompleted();
            mInTheatersMovieView.hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mInTheatersMovieView.hideLoading();
            mInTheatersMovieView.showRetry();
            mInTheatersMovieView.showError("do with this error");
        }

        @Override
        public void onNext(List<MovieModel> movies) {
            super.onNext(movies);
            mInTheatersMovieView.showMoives(movies);
        }
    }

    private final class RefreshMoviesSubscriber extends DefaultSubscriber<List<MovieModel>> {
        @Override
        public void onCompleted() {
            super.onCompleted();
            mInTheatersMovieView.hideRefresh();
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            mInTheatersMovieView.hideRefresh();
            mInTheatersMovieView.showError("do with this error");
        }

        @Override
        public void onNext(List<MovieModel> movies) {
            super.onNext(movies);
            mInTheatersMovieView.showMoives(movies);
        }
    }

}
