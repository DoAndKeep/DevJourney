package com.doandkeep.devjourney.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.doandkeep.devjourney.R;

import butterknife.ButterKnife;

/**
 * Created by zhangtao on 16/7/21.
 */
public abstract class BaseActvity extends AppCompatActivity {

    protected BaseActvity mActvity;
    protected ToolbarHelper mToolbarHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActvity = this;

        setContentView(getContentViewId());
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            // 默认不显示原生标题
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            mToolbarHelper = new ToolbarHelper(toolbar);

            if (!TextUtils.isEmpty(getToolbarTitle())) {
                mToolbarHelper.setTitle(getToolbarTitle());
            }

            hanldeToolbar(toolbar);
        }

        if (getIntent() != null) {
            handleIntent(getIntent());
        }
    }

    protected abstract int getContentViewId();

    protected abstract String getToolbarTitle();

    protected void hanldeToolbar(Toolbar toolbar) {

    }

    protected void handleIntent(Intent intent) {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                FragmentManager fm = getSupportFragmentManager();
                if (fm != null && fm.getBackStackEntryCount() > 0) {
                    fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                } else {
                    finish();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    class ToolbarHelper {

        private Toolbar mToolbar;

        public ToolbarHelper(Toolbar toolbar) {
            this.mToolbar = toolbar;
        }

        public Toolbar getToolbar() {
            return mToolbar;
        }

        public void setTitle(String title) {
            TextView titleTV = (TextView) mToolbar.findViewById(R.id.toolbar_title);
            titleTV.setText(title);
        }

        public void setMenuTitle(String menuTitle, View.OnClickListener listener) {
            TextView menuTitleTV = (TextView) mToolbar.findViewById(R.id.toolbar_menu_title);
            menuTitleTV.setText(menuTitle);
            menuTitleTV.setOnClickListener(listener);
        }


    }
}
