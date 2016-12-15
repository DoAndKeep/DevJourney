package com.doandkeep.devjourney.base.domain;

/**
 * UseCase积累
 * Created by zhangtao on 2016/11/8.
 */

import com.doandkeep.devjourney.base.presentation.ErrorModel;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;
import timber.log.Timber;

/**
 * Use cases are the entry points to the domain layer.
 */
public abstract class UseCase<Q extends UseCase.RequestValues, P extends UseCase.ResponseValues> {

    private Subscription mSubscription = Subscriptions.empty();

    protected abstract Observable buildUseCaseObservable(Q requestValues);

    public void execute(Q requestValues, final UseCaseCallback<P> caseCallback) {
        this.mSubscription = this.buildUseCaseObservable(requestValues)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DefaultSubscriber<P>() {
                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        Timber.e("UseCase onError：" + e.getMessage());
                        caseCallback.onError(new ErrorModel(-1, "TodoError"));
                    }

                    @Override
                    public void onNext(P o) {
                        super.onNext(o);
                        Timber.i("UseCase onNext");
                        caseCallback.onSuccess(o);
                    }
                });
    }

    public void cancel() {
        if (!mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }

    public interface RequestValues {

    }

    public interface ResponseValues {

    }

    public interface UseCaseCallback<P> {
        void onSuccess(P response);

        void onError(ErrorModel errorModel);
    }

}
