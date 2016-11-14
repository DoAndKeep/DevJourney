package com.doandkeep.devjourney.base.presentation;

/**
 * MVP模式中的Presenter接口
 * Created by zhangtao on 2016/11/9.
 */
public interface Presenter {
    void resume();

    void pause();

    void destroy();
}
