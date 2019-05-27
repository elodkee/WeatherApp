package com.example.weatherapp.home.forecast;

import com.example.weatherapp.base.BaseView;
import com.example.weatherapp.data.model.ForecastResult;

public interface ForecastView extends BaseView {
    void onLoadForecast(ForecastResult forecastResult);
}
