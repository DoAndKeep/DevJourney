package com.doandkeep.devjourney.base.presentation;

import android.content.Context;

/**
 *
 */
public interface LoadDataView<T> extends BaseView<T> {
    void showLoading();

    void hideLoading();

    void showRetry();

    void hideRetry();

    void showError(String msg);

    Context context();
}
