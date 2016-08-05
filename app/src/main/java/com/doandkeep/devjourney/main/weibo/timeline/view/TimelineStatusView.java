package com.doandkeep.devjourney.main.weibo.timeline.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.doandkeep.devjourney.R;
import com.doandkeep.devjourney.bean.weibo.TimelineStatus;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhangtao on 16/8/5.
 */
public class TimelineStatusView extends FrameLayout {

    @BindView(R.id.status_user_name_tv)
    TextView mUserNameTV;
    @BindView(R.id.status_text_tv)
    TextView mTextTV;

    public TimelineStatusView(Context context) {
        super(context);
        init(context);
    }

    public TimelineStatusView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        View.inflate(context, R.layout.view_timeline_status, this);
        ButterKnife.bind(this, this);
    }

    public void setData(TimelineStatus status) {
        mUserNameTV.setText(status.getUser().getName());
        mTextTV.setText(status.getText());
    }
}
