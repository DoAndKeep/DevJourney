package com.doandkeep.devjourney.features.douban;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.doandkeep.devjourney.R;
import com.doandkeep.devjourney.base.presentation.BaseActvity;
import com.doandkeep.devjourney.features.douban.movie.presentation.view.DoubanMovieActivity;
import com.doandkeep.devjourney.util.view.ToolbarHelper;

/**
 * Created by zhangtao on 16/7/15.
 */
public class DoubanActivity extends BaseActvity implements DoubanFragment.DoubanListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.initActivity(savedInstanceState);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_layout;
    }

    @Override
    protected void initToolbar(ToolbarHelper toolbarHelper) {
        toolbarHelper.setTitle("豆瓣的天下");
    }

    @Override
    public void viewMovie() {
        Intent intent = new Intent(DoubanActivity.this, DoubanMovieActivity.class);
        startActivity(intent);
    }

    private void initActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container_layout, new DoubanFragment());
        }
    }
}
