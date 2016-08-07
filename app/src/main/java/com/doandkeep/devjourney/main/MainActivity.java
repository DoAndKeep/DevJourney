package com.doandkeep.devjourney.main;

import android.content.Intent;

import com.doandkeep.devjourney.R;
import com.doandkeep.devjourney.base.BaseActvity;
import com.doandkeep.devjourney.main.demo.DemoActivity;
import com.doandkeep.devjourney.main.weibo.WeiboActivity;

import butterknife.OnClick;

public class MainActivity extends BaseActvity {


    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void handleIntent(Intent intent) {
        super.handleIntent(intent);
    }

    @Override
    protected String getToolbarTitle() {
        return "首页";
    }

    @Override
    protected void hanldeToolbar(ToolbarHelper toolbarHelper) {
        toolbarHelper.getToolbar().setNavigationIcon(null);
    }

    @OnClick(R.id.main_demo_btn)
    public void forwardDemo() {
        Intent intent = new Intent(MainActivity.this, DemoActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.main_weibo_btn)
    public void forwardWeibo() {
        Intent intent = new Intent(MainActivity.this, WeiboActivity.class);
        startActivity(intent);
    }

}
