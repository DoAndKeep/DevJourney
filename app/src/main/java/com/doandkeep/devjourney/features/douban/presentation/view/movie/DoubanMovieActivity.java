package com.doandkeep.devjourney.features.douban.presentation.view.movie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.doandkeep.devjourney.R;
import com.doandkeep.devjourney.base.di.HasComponent;
import com.doandkeep.devjourney.base.presentation.BaseActvity;
import com.doandkeep.devjourney.features.douban.presentation.DoubanMoviePagerAdapter;
import com.doandkeep.devjourney.features.douban.presentation.di.DaggerDoubanComponent;
import com.doandkeep.devjourney.features.douban.presentation.di.DoubanComponent;
import com.doandkeep.devjourney.features.douban.presentation.di.DoubanModule;
import com.doandkeep.devjourney.util.view.ToolbarHelper;

import butterknife.BindView;

/**
 * Created by zhangtao on 16/8/3.
 */
public class DoubanMovieActivity extends BaseActvity implements HasComponent<DoubanComponent> {

    @BindView(R.id.douban_moive_tablayout)
    TabLayout mTabLayout;
    @BindView(R.id.douban_movie_viewpager)
    ViewPager mViewPager;

    private DoubanMoviePagerAdapter mPagerAdapter;

    private DoubanComponent mDoubanComponent;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_douban_movie;
    }

    @Override
    protected void initToolbar(ToolbarHelper toolbarHelper) {
        toolbarHelper.setTitle("豆瓣电影");
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initInjector();

        mPagerAdapter = new DoubanMoviePagerAdapter(DoubanMovieActivity.this, this.getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            mTabLayout.getTabAt(i).setCustomView(mPagerAdapter.getTabView(i));
        }
    }

    @Override
    public DoubanComponent getComponent() {
        return mDoubanComponent;
    }

    private void initInjector() {
        mDoubanComponent = DaggerDoubanComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .doubanModule(new DoubanModule("北京"))
                .build();
    }

}
