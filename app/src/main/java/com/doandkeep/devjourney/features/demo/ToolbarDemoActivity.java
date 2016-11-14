package com.doandkeep.devjourney.features.demo;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.doandkeep.devjourney.R;
import com.doandkeep.devjourney.base.presentation.BaseActvity;
import com.doandkeep.devjourney.util.view.ToolbarHelper;

/**
 * Created by zhangtao on 16/8/7.
 */
public class ToolbarDemoActivity extends BaseActvity {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_demo_toolbar;
    }

    @Override
    protected void initToolbar(ToolbarHelper toolbarHelper) {

        toolbarHelper.setTitle("自定义");

        Toolbar toolbar = toolbarHelper.getToolbar();

        // 显示应用的Logo
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);

        // 显示标题和子标题
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        toolbar.setTitle("ToolbarDemo");
        toolbar.setSubtitle("the detail of toolbar");

        // 显示导航按钮
        toolbar.setNavigationIcon(R.drawable.icon_back);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar_demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolbar_action1:
                // do something
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
