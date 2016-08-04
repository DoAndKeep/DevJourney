package com.doandkeep.devjourney.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by zhangtao on 16/7/21.
 */
public abstract class BaseFragment extends Fragment {

    protected BaseActvity mActvity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResId(), container, false);
        ButterKnife.bind(this, view);
        initView(view, savedInstanceState);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (getActivity() != null && getActivity() instanceof BaseActvity) {
            mActvity = (BaseActvity) getActivity();
        }
    }

    protected abstract int getLayoutResId();

    protected abstract void initView(View view, Bundle savedInstanceState);

}
