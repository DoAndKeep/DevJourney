package com.doandkeep.devjourney.features.douban.presentation.view.movie;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.doandkeep.devjourney.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhangtao on 16/8/4.
 */
public class DoubanMovieTabView extends FrameLayout {

    @BindView(R.id.tab_laber_tv)
    TextView mLaberTV;

    public DoubanMovieTabView(Context context) {
        super(context);
        init(context);
    }

    public DoubanMovieTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        View.inflate(context, R.layout.view_douban_movie_tab, this);
        ButterKnife.bind(this, this);
    }

    public void setData(String laber) {
        mLaberTV.setText(laber);
    }
}
