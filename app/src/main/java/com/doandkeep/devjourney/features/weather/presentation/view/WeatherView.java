package com.doandkeep.devjourney.features.weather.presentation.view;

import com.doandkeep.devjourney.base.presentation.LoadDataView;
import com.doandkeep.devjourney.features.weather.presentation.model.WeatherModel;

/**
 * Created by zhangtao on 2016/11/9.
 */

public interface WeatherView extends LoadDataView {
    void renderWeather(WeatherModel weatherModel);
}
