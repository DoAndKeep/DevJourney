package com.doandkeep.devjourney.features.douban.timeline.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;

import com.doandkeep.devjourney.features.douban.presentation.view.DoubanMovieFragment;
import com.doandkeep.devjourney.features.douban.presentation.view.DoubanMovieTabView;

/**
 * Created by zhangtao on 16/8/3.
 */
public class DoubanMoviePagerAdapter extends FragmentPagerAdapter {

    private static final int PAGE_COUNT = 3;

    private Context mContext;

    public DoubanMoviePagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return DoubanMovieFragment.newInstance(0);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    public View getTabView(int position) {
        DoubanMovieTabView tabView = new DoubanMovieTabView(mContext);
        switch (position) {
            case 0:
                tabView.setData("正在热映");
                break;
            case 1:
                tabView.setData("即将上映");
                break;
            case 2:
                tabView.setData("TOP榜");
                break;
            default:
                tabView.setData("电影");
                break;
        }
        return tabView;
    }
}
