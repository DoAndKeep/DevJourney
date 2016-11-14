package com.doandkeep.devjourney.features.weather.presentation.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.doandkeep.devjourney.R;
import com.doandkeep.devjourney.base.presentation.BaseFragment;
import com.doandkeep.devjourney.features.weather.presentation.di.WeatherComponent;
import com.doandkeep.devjourney.features.weather.presentation.model.WeatherModel;
import com.doandkeep.devjourney.features.weather.presentation.presenter.WeatherPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import timber.log.Timber;

/**
 * Created by zhangtao on 2016/11/9.
 */
public class WeatherFragment extends BaseFragment implements WeatherView {

    public interface WeatherListener {

    }

    @Inject
    WeatherPresenter mWeatherPresenter;

    @BindView(R.id.weather_weather_tv)
    TextView mWeatherTV;
    @BindView(R.id.progress_view)
    View mProgressView;
    @BindView(R.id.retry_view)
    View mRetryView;

    private WeatherListener mWeatherListener;

    public WeatherFragment() {
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof WeatherListener) {
            this.mWeatherListener = (WeatherListener) context;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(WeatherComponent.class).inject(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_weather;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Timber.i("onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        this.mWeatherPresenter.setView(this);
        if (savedInstanceState == null) {
            this.loadWeather();
            Timber.i("WeatherFragment onViewCreated");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        this.mWeatherPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.mWeatherPresenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mWeatherPresenter.destroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.mWeatherListener = null;
    }

    @Override
    public void renderWeather(WeatherModel weatherModel) {
        if (weatherModel != null) {
            mWeatherTV.setText(weatherModel.getWeather());
        }
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
        // do toast
    }

    @Override
    public Context context() {
        return this.getActivity().getApplicationContext();
    }

    private void loadWeather() {
        this.mWeatherPresenter.init();
    }


}
