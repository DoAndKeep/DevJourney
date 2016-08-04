package com.doandkeep.devjourney.main;

import android.content.Intent;
import android.support.v7.widget.Toolbar;

import com.doandkeep.devjourney.R;
import com.doandkeep.devjourney.base.BaseActvity;
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
    protected void hanldeToolbar(Toolbar toolbar) {
        toolbar.setNavigationIcon(null);
    }

    @OnClick(R.id.main_weibo_btn)
    public void forwardWeibo() {
        Intent intent = new Intent(MainActivity.this, WeiboActivity.class);
        startActivity(intent);
    }

}
