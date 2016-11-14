package com.doandkeep.devjourney.features.weibo.timeline;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.doandkeep.devjourney.R;
import com.doandkeep.devjourney.base.presentation.BaseActvity;
import com.doandkeep.devjourney.features.weibo.timeline.adapter.TimelinePagerAdapter;
import com.doandkeep.devjourney.util.view.ToolbarHelper;

import butterknife.BindView;

/**
 * Created by zhangtao on 16/8/3.
 */
public class WeiboTimelineActivity extends BaseActvity {

    @BindView(R.id.timeline_tablayout)
    TabLayout mTabLayout;
    @BindView(R.id.timeline_viewpager)
    ViewPager mViewPager;

    private TimelinePagerAdapter mTimelineAdapter;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_weibo_timeline;
    }

    @Override
    protected void initToolbar(ToolbarHelper toolbarHelper) {
        toolbarHelper.setTitle("微博状态");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTimelineAdapter = new TimelinePagerAdapter(this, this.getSupportFragmentManager());

        mViewPager.setAdapter(mTimelineAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            mTabLayout.getTabAt(i).setCustomView(mTimelineAdapter.getTabView(i));
        }

    }
}
