package com.doandkeep.devjourney.main.weibo.timeline.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;

import com.doandkeep.devjourney.R;
import com.doandkeep.devjourney.main.weibo.Constants;
import com.doandkeep.devjourney.main.weibo.timeline.WeiboTimelineFragment;
import com.doandkeep.devjourney.main.weibo.timeline.view.TimelineTabView;

/**
 * Created by zhangtao on 16/8/3.
 */
public class TimelinePagerAdapter extends FragmentPagerAdapter {

    private static final int PAGE_COUNT = 3;

    private Context mContext;

    public TimelinePagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        int type;
        switch (position) {
            case 0:
                type = Constants.TYPE_TIMELINE_PUBLIC;
                break;
            case 1:
                type = Constants.TYPE_TIMELINE_FRIEND;
                break;
            case 2:
                type = Constants.TYPE_TIMELINE_MINE;
                break;
            default:
                type = Constants.TYPE_TIMELINE_PUBLIC;
                break;
        }
        return WeiboTimelineFragment.newInstance(type);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Drawable drawable;
        String title;
        switch (position) {
            case 0:
                drawable = ContextCompat.getDrawable(mContext, R.drawable.icon_weibo_timeline_public);
                title = "广场";
                break;
            case 1:
                drawable = ContextCompat.getDrawable(mContext, R.drawable.icon_weibo_timeline_friend);
                title = "好友";
                break;
            case 2:
                drawable = ContextCompat.getDrawable(mContext, R.drawable.icon_weibo_timeline_mine);
                title = "我";
                break;
            default:
                drawable = ContextCompat.getDrawable(mContext, R.drawable.icon_weibo_timeline_public);
                title = "微博";
                break;
        }
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan imageSpan = new ImageSpan(drawable, ImageSpan.ALIGN_BOTTOM);
        SpannableString spannableString = new SpannableString(" " + title);
        spannableString.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return spannableString;
    }

    public View getTabView(int position) {
        TimelineTabView tabView = new TimelineTabView(mContext);
        switch (position) {
            case 0:
                tabView.setData(R.drawable.icon_weibo_timeline_public);
                break;
            case 1:
                tabView.setData(R.drawable.icon_weibo_timeline_friend);
                break;
            case 2:
                tabView.setData(R.drawable.icon_weibo_timeline_mine);
                break;
            default:
                tabView.setData(R.drawable.icon_weibo_timeline_public);
                break;
        }
        return tabView;
    }
}
