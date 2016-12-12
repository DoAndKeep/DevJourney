package com.doandkeep.devjourney.base.domain;

/**
 * Created by zhangtao on 2016/11/8.
 */

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Use cases are the entry points to the domain layer.
 */
public abstract class UseCase<Q extends UseCase.RequestValues, P extends UseCase.ResponseValues> {

    private Subscription mSubscription = Subscriptions.empty();

    protected abstract Observable buildUseCaseObservable(Q requestValues);

    public void execute(Q requestValues, Subscriber<P> useCaseSubscriber) {
        this.mSubscription = this.buildUseCaseObservable(requestValues)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(useCaseSubscriber);
    }

    public void unsubscribe() {
        if (!mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }

    public interface RequestValues {

    }

    public interface ResponseValues {

    }

}
