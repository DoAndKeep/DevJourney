package com.doandkeep.devjourney.main.weibo.timeline;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.doandkeep.devjourney.R;
import com.doandkeep.devjourney.base.BaseActvity;

import butterknife.BindView;

/**
 * Created by zhangtao on 16/8/3.
 */
public class WeiboTimelineActivity extends BaseActvity {

    @BindView(R.id.timeline_tablayout)
    TabLayout mTabLayout;
    @BindView(R.id.timeline_viewpager)
    ViewPager mViewPager;

    private WeiboTimelineAdapter mTimelineAdapter;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_weibo_timeline;
    }

    @Override
    protected String getToolbarTitle() {
        return "微博状态";
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTimelineAdapter = new WeiboTimelineAdapter(mActvity, mActvity.getSupportFragmentManager());

        mViewPager.setAdapter(mTimelineAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            mTabLayout.getTabAt(i).setCustomView(mTimelineAdapter.getTabView(i));
        }

    }
}
