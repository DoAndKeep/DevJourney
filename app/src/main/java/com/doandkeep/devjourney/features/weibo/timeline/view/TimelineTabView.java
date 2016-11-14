package com.doandkeep.devjourney.features.weibo.timeline.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.doandkeep.devjourney.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhangtao on 16/8/4.
 */
public class TimelineTabView extends FrameLayout {

    @BindView(R.id.timeline_tab_icon_iv)
    ImageView mIconIV;

    public TimelineTabView(Context context) {
        super(context);
        init(context);
    }

    public TimelineTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        View.inflate(context, R.layout.view_weibo_timeline_tab, this);
        ButterKnife.bind(this, this);
    }

    public void setData(int iconResId) {
        mIconIV.setImageResource(iconResId);
    }
}
