package com.doandkeep.devjourney.features.douban.movie.presentation.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.doandkeep.devjourney.R;
import com.doandkeep.devjourney.base.presentation.BaseActvity;
import com.doandkeep.devjourney.features.douban.movie.presentation.DoubanMoviePagerAdapter;
import com.doandkeep.devjourney.features.douban.movie.presentation.di.DaggerDoubanComponent;
import com.doandkeep.devjourney.features.douban.movie.presentation.di.DoubanMovieModule;
import com.doandkeep.devjourney.features.douban.movie.presentation.di.DoubanMovieViewModule;
import com.doandkeep.devjourney.features.douban.movie.presentation.presenter.ComingSoonMoviePresenter;
import com.doandkeep.devjourney.features.douban.movie.presentation.presenter.InTheatersMoviePresenter;
import com.doandkeep.devjourney.features.douban.movie.presentation.presenter.Top250MoviePresenter;
import com.doandkeep.devjourney.util.view.ToolbarHelper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by zhangtao on 16/8/3.
 */
public class DoubanMovieActivity extends BaseActvity {

    @BindView(R.id.douban_moive_tablayout)
    TabLayout mTabLayout;
    @BindView(R.id.douban_movie_viewpager)
    ViewPager mViewPager;

    @Inject
    InTheatersMoviePresenter mInTheatersMoviePresenter;
    @Inject
    ComingSoonMoviePresenter mComingSoonMoviePresenter;
    @Inject
    Top250MoviePresenter mTop250MoviePresenter;

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

        InTheatersMovieFragment inTheatersMovieFragment = InTheatersMovieFragment.newInstance();
        ComingSoonMovieFragment comingSoonMovieFragment = ComingSoonMovieFragment.newInstance();
        Top250MovieFragment top250MovieFragment = Top250MovieFragment.newInstance();

        DaggerDoubanComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .doubanMovieModule(new DoubanMovieModule())
                .doubanMovieViewModule(new DoubanMovieViewModule(inTheatersMovieFragment, comingSoonMovieFragment, top250MovieFragment))
                .build().inject(this);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(inTheatersMovieFragment);
        fragments.add(comingSoonMovieFragment);
        fragments.add(top250MovieFragment);

        DoubanMoviePagerAdapter pagerAdapter = new DoubanMoviePagerAdapter(DoubanMovieActivity.this, this.getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(pagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            mTabLayout.getTabAt(i).setCustomView(pagerAdapter.getTabView(i));
        }
    }

}
