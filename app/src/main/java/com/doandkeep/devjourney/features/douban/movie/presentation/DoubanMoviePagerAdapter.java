package com.doandkeep.devjourney.features.douban.movie.presentation;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import com.doandkeep.devjourney.features.douban.movie.presentation.view.item.DoubanMovieTabView;

import java.util.List;

/**
 * Created by zhangtao on 16/8/3.
 */
public class DoubanMoviePagerAdapter extends FragmentPagerAdapter {

    private static final String[] PAGE_LABER = {"正在热映", "即将上映", "Top250"};

    private Context mContext;
    private List<Fragment> mFragments;

    public DoubanMoviePagerAdapter(Context context, FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.mContext = context;
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments == null ? 0 : mFragments.size();
    }

    public View getTabView(int position) {
        DoubanMovieTabView tabView = new DoubanMovieTabView(mContext);
        tabView.setData(PAGE_LABER[position]);
        return tabView;
    }
}
