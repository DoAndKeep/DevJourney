package com.doandkeep.devjourney.features.main.presentation.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.doandkeep.devjourney.R;
import com.doandkeep.devjourney.base.presentation.BaseActvity;
import com.doandkeep.devjourney.features.demo.DemoActivity;
import com.doandkeep.devjourney.features.weather.presentation.view.WeatherActivity;
import com.doandkeep.devjourney.features.douban.presentation.view.DoubanActivity;
import com.doandkeep.devjourney.util.view.ToolbarHelper;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActvity {

    @BindView(R.id.main_root_layout)
    View mRootLayout;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initToolbar(ToolbarHelper toolbarHelper) {
        toolbarHelper.setTitle("首页");
        toolbarHelper.getToolbar().setNavigationIcon(null);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Snackbar.make(mRootLayout, "欢迎来到Dev Journey!", Snackbar.LENGTH_INDEFINITE)
                .setDuration(5000)
                .setAction("开始旅途", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // TODO
                    }
                }).show();
    }

    @OnClick(R.id.main_weather_btn)
    public void forwardWeather() {
        Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.main_demo_btn)
    public void forwardDemo() {
        Intent intent = new Intent(MainActivity.this, DemoActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.main_douban_btn)
    public void forwardDouban() {
        Intent intent = new Intent(MainActivity.this, DoubanActivity.class);
        startActivity(intent);
    }

}
