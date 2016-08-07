package com.doandkeep.devjourney.main.demo;

import android.content.Intent;

import com.doandkeep.devjourney.R;
import com.doandkeep.devjourney.base.BaseActvity;

import butterknife.OnClick;

/**
 * Created by zhangtao on 16/8/7.
 */
public class DemoActivity extends BaseActvity {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_demo;
    }

    @Override
    protected String getToolbarTitle() {
        return "Demo";
    }

    @OnClick(R.id.demo_toolbar_btn)
    public void forwardToolbarDemo() {
        Intent intent = new Intent(DemoActivity.this, ToolbarDemoActivity.class);
        startActivity(intent);
    }
}
