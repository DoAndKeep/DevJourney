package com.doandkeep.devjourney.features.douban.presentation;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import com.doandkeep.devjourney.features.douban.presentation.view.movie.DoubanMovieTabView;
import com.doandkeep.devjourney.features.douban.presentation.view.movie.DoubanMoviesComingSoonFragment;
import com.doandkeep.devjourney.features.douban.presentation.view.movie.DoubanMoviesInTheatersFragment;
import com.doandkeep.devjourney.features.douban.presentation.view.movie.DoubanMoviesTop250Fragment;

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
        switch (position) {
            case 0:
                return new DoubanMoviesInTheatersFragment();
            case 1:
                return new DoubanMoviesComingSoonFragment();
            case 2:
                return new DoubanMoviesTop250Fragment();
            default:
                return new DoubanMoviesInTheatersFragment();
        }
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
