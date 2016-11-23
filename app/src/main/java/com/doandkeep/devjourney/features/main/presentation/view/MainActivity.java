package com.doandkeep.devjourney.features.main.presentation.view;

import android.content.Intent;

import com.doandkeep.devjourney.R;
import com.doandkeep.devjourney.base.presentation.BaseActvity;
import com.doandkeep.devjourney.features.demo.DemoActivity;
import com.doandkeep.devjourney.features.weather.presentation.view.WeatherActivity;
import com.doandkeep.devjourney.features.douban.presentation.view.DoubanActivity;
import com.doandkeep.devjourney.util.view.ToolbarHelper;

import butterknife.OnClick;

public class MainActivity extends BaseActvity {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initToolbar(ToolbarHelper toolbarHelper) {
        toolbarHelper.setTitle("首页");
        toolbarHelper.getToolbar().setNavigationIcon(null);
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
