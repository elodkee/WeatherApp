package com.example.weatherapp.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Forecast {

    @SerializedName("forecastday")
    private ArrayList<Forecastday> mForecastdays;

    public ArrayList<Forecastday> getForecastdays() {
        return mForecastdays;
    }

    public void setForecastdays(ArrayList<Forecastday> forecastdays) {
        this.mForecastdays = forecastdays;
    }
}
