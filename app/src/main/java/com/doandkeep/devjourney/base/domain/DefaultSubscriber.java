package com.doandkeep.devjourney.base.domain;

import rx.Subscriber;

/**
 * Default subscriber base class to be used whenever you want default error handling.
 * Created by zhangtao on 2016/11/9.
 */
public class DefaultSubscriber<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {
        // no-op by default.
    }

    @Override
    public void onError(Throwable e) {
        // no-op by default.
    }

    @Override
    public void onNext(T o) {
        // no-op by default.
    }
}
