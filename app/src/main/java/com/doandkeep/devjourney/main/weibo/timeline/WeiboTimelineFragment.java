package com.doandkeep.devjourney.main.weibo.timeline;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.doandkeep.devjourney.R;
import com.doandkeep.devjourney.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by zhangtao on 16/8/3.
 */
public class WeiboTimelineFragment extends BaseFragment {

    private static final String ARG_TIMELINE_TYPE = "ARG_TIMELINE_TYPE";

    @BindView(R.id.timeline_content_tv)
    TextView mContentTV;

    private int mType;

    public static WeiboTimelineFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt(ARG_TIMELINE_TYPE, type);
        WeiboTimelineFragment fragment = new WeiboTimelineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mType = getArguments().getInt(ARG_TIMELINE_TYPE);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_weibo_timeline;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mContentTV.setText("展示类型为" + mType + "的微博");
    }

}
