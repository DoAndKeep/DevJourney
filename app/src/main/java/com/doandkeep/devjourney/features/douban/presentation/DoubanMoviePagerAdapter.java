package com.doandkeep.devjourney.features.douban.presentation;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import com.doandkeep.devjourney.features.douban.presentation.view.movie.DoubanMovieListFragment;
import com.doandkeep.devjourney.features.douban.presentation.view.movie.DoubanMovieTabView;

/**
 * Created by zhangtao on 16/8/3.
 */
public class DoubanMoviePagerAdapter extends FragmentPagerAdapter {

    private static final int PAGE_COUNT = 3;
    private static final String[] PAGE_LABER = {"正在热映", "即将上映", "Top250"};

    private Context mContext;

    public DoubanMoviePagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return DoubanMovieListFragment.newInstance(0);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    public View getTabView(int position) {
        DoubanMovieTabView tabView = new DoubanMovieTabView(mContext);
        tabView.setData(PAGE_LABER[position]);
        return tabView;
    }
}
