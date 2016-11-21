package com.doandkeep.devjourney.features.weibo.presentation.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.doandkeep.devjourney.R;
import com.doandkeep.devjourney.base.presentation.BaseFragment;

import butterknife.OnClick;

/**
 * Created by zhangtao on 2016/11/21.
 */

public class WeiboFragment extends BaseFragment {

    public interface WeiboListener {
        void doBind();

        void viewWeiboList();
    }

    private WeiboListener mWeiboListener;

    public WeiboFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_weibo;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof WeiboListener) {
            this.mWeiboListener = (WeiboListener) context;
        }
    }

    @OnClick(R.id.weibo_bind_btn)
    void doBind() {
        if (this.mWeiboListener != null) {
            this.mWeiboListener.doBind();
        }
    }

    @OnClick(R.id.weibo_timlines_btn)
    void viewWeiboList() {
        if (this.mWeiboListener != null) {
            this.mWeiboListener.viewWeiboList();
        }
    }
}
