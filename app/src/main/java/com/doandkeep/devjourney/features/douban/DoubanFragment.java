package com.doandkeep.devjourney.features.douban;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.doandkeep.devjourney.R;
import com.doandkeep.devjourney.base.presentation.BaseFragment;

import butterknife.OnClick;

/**
 * Created by zhangtao on 2016/11/21.
 */

public class DoubanFragment extends BaseFragment {

    public interface DoubanListener {
        void viewMovie();
    }

    private DoubanListener mDoubanListener;

    public DoubanFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_douban;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DoubanListener) {
            this.mDoubanListener = (DoubanListener) context;
        }
    }

    @OnClick(R.id.douban_movie_btn)
    void doBind() {
        if (this.mDoubanListener != null) {
            this.mDoubanListener.viewMovie();
        }
    }
}
