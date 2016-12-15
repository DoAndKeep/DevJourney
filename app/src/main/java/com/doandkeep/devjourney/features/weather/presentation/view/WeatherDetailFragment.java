package com.doandkeep.devjourney.features.weather.presentation.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.doandkeep.devjourney.R;
import com.doandkeep.devjourney.base.presentation.BaseFragment;
import com.doandkeep.devjourney.features.weather.presentation.WeatherDetailContract;
import com.doandkeep.devjourney.features.weather.presentation.model.WeatherDetailModel;
import com.doandkeep.devjourney.util.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 天气详情Fragment
 * Created by zhangtao on 2016/11/9.
 */
public class WeatherDetailFragment extends BaseFragment implements WeatherDetailContract.View {

    @BindView(R.id.weather_weather_tv)
    TextView mWeatherTV;
    @BindView(R.id.progress_view)
    View mProgressView;
    @BindView(R.id.retry_view)
    View mRetryView;

    private WeatherDetailContract.Presenter mWeatherDetailPresenter;

    public static WeatherDetailFragment newInstance() {
        return new WeatherDetailFragment();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState == null) {
            loadWeatherDetail();
        }
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_weather;
    }

    @Override
    public void onResume() {
        super.onResume();
        mWeatherDetailPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mWeatherDetailPresenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mWeatherDetailPresenter.destroy();
    }

    @Override
    public void setPresenter(WeatherDetailContract.Presenter presenter) {
        mWeatherDetailPresenter = presenter;
    }

    @Override
    public void showWeatherDetail(WeatherDetailModel weatherDetailModel) {
        mWeatherTV.setText(weatherDetailModel.toString());
    }

    @Override
    public void showLoading() {
        this.mProgressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        this.mProgressView.setVisibility(View.GONE);
    }

    @Override
    public void showRetry() {
        this.mRetryView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        this.mRetryView.setVisibility(View.GONE);
    }

    @Override
    public void showError(String msg) {
        ToastUtils.showErrorToase(context(), msg);
    }

    @Override
    public Context context() {
        return getContext().getApplicationContext();
    }

    @OnClick(R.id.retry_btn)
    void onRetryBtnClicked() {
        loadWeatherDetail();
    }

    private void loadWeatherDetail() {
        mWeatherDetailPresenter.loadWeatherDetail("北京");
    }


}
