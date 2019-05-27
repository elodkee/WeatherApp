package com.example.weatherapp.home.viewpager.view;

import com.example.weatherapp.base.BaseView;
import com.example.weatherapp.data.model.ForecastResult;

public interface CurrentTempView extends BaseView {
    void onLoadCurrent(ForecastResult forecastResult);
}
