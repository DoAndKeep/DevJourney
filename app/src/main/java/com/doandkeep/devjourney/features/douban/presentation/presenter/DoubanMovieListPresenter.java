package com.doandkeep.devjourney.features.douban.presentation.presenter;

import com.doandkeep.devjourney.base.domain.DefaultSubscriber;
import com.doandkeep.devjourney.base.domain.UseCase;
import com.doandkeep.devjourney.base.presentation.Presenter;
import com.doandkeep.devjourney.features.douban.data.entity.DoubanMovieEntity;
import com.doandkeep.devjourney.features.douban.presentation.view.movie.DoubanMovieListView;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by zhangtao on 2016/11/23.
 */

public class DoubanMovieListPresenter implements Presenter {

    private UseCase mUseCase;
    private DoubanMovieListView mView;

    @Inject
    public DoubanMovieListPresenter(@Named("movieInTheaters") UseCase useCase) {
        this.mUseCase = useCase;
    }

    public void setView(DoubanMovieListView doubanMovieListView) {
        this.mView = doubanMovieListView;
    }


    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }


    public void init() {
        loadMovieList();
    }

    private void loadMovieList() {
        showLoadingView();
        hideRetryView();
        getMovieList();
    }

    private void getMovieList() {
        mUseCase.execute(new GetMoiveInTheatersSubscriber());
    }

    private void showLoadingView() {
        mView.showLoading();
    }

    private void hideLoadingView() {
        mView.hideLoading();
    }

    private void showRetryView() {
        mView.showRetry();
    }

    private void hideRetryView() {
        mView.hideRetry();
    }

    private void showErrorMsg(String msg) {
        mView.showError(msg);
    }

    private void showMovieListInView(List<DoubanMovieEntity> movies) {
        mView.renderMovie(movies);
    }

    private final class GetMoiveInTheatersSubscriber extends DefaultSubscriber<List<DoubanMovieEntity>> {
        @Override
        public void onCompleted() {
            super.onCompleted();
            DoubanMovieListPresenter.this.hideLoadingView();
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            DoubanMovieListPresenter.this.hideLoadingView();
            DoubanMovieListPresenter.this.showRetryView();
            DoubanMovieListPresenter.this.showErrorMsg("do with this error");
        }

        @Override
        public void onNext(List<DoubanMovieEntity> movies) {
            super.onNext(movies);
            DoubanMovieListPresenter.this.showMovieListInView(movies);
        }
    }

}
