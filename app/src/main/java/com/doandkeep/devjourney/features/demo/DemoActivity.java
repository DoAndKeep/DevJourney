package com.doandkeep.devjourney.features.demo;

import android.content.Intent;

import com.doandkeep.devjourney.R;
import com.doandkeep.devjourney.base.presentation.BaseActvity;
import com.doandkeep.devjourney.util.view.ToolbarHelper;

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
    protected void initToolbar(ToolbarHelper toolbarHelper) {
        toolbarHelper.setTitle("Demo");
    }

    @OnClick(R.id.demo_toolbar_btn)
    public void forwardToolbarDemo() {
        Intent intent = new Intent(DemoActivity.this, ToolbarDemoActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.demo_custome_view_btn)
    public void forwardCustomViewDemo() {
        Intent intent = new Intent(DemoActivity.this, CustomViewActivity.class);
        startActivity(intent);
    }
}
