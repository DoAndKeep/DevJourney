package com.doandkeep.devjourney.features.weather.presentation;

import com.doandkeep.devjourney.base.presentation.BasePresenter;
import com.doandkeep.devjourney.base.presentation.LoadDataView;
import com.doandkeep.devjourney.features.weather.presentation.model.WeatherDetailModel;

/**
 * 天气详情view与presenter的约定
 * Created by zhangtao on 2016/12/12.
 */

public interface WeatherDetailContract {

    interface View extends LoadDataView<Presenter> {
        void showWeatherDetail(WeatherDetailModel weatherDetailModel);
    }

    interface Presenter extends BasePresenter {

        void loadWeatherDetail(String cityName);

    }
}
