package com.doandkeep.devjourney.base.presentation;

import android.content.Context;

/**
 * 用来加载数据的接口
 * Created by zhangtao on 2016/11/9.
 */
public interface LoadDataView {
    void showLoading();

    void hideLoading();

    void showRetry();

    void hideRetry();

    void showError(String msg);

    Context context();
}
