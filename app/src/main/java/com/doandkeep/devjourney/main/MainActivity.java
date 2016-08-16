package com.doandkeep.devjourney.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.doandkeep.devjourney.R;
import com.doandkeep.devjourney.base.BaseActvity;
import com.doandkeep.devjourney.bean.weather.WeatherWrapper;
import com.doandkeep.devjourney.main.demo.DemoActivity;
import com.doandkeep.devjourney.main.weibo.WeiboActivity;
import com.doandkeep.devjourney.retrofit.ServiceGenerator;
import com.doandkeep.devjourney.retrofit.service.WeatherService;
import com.doandkeep.devjourney.util.DebugLog;

import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActvity {

    private static final String TAG = MainActivity.class.getCanonicalName();

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected String getToolbarTitle() {
        return "首页";
    }

    @Override
    protected void hanldeToolbar(ToolbarHelper toolbarHelper) {
        toolbarHelper.getToolbar().setNavigationIcon(null);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WeatherService weatherService = ServiceGenerator.createService(WeatherService.class);
        Call<WeatherWrapper> call = weatherService.weather("http://apis.baidu.com/apistore/weatherservice/weather", "北京");
        call.enqueue(new Callback<WeatherWrapper>() {
            @Override
            public void onResponse(Call<WeatherWrapper> call, Response<WeatherWrapper> response) {
                DebugLog.i(TAG, "weather:" + response.body().getRetData().getWeather());
            }

            @Override
            public void onFailure(Call<WeatherWrapper> call, Throwable t) {

            }
        });

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
