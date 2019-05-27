package com.example.weatherapp.data.model;

import com.google.gson.annotations.SerializedName;

public class ForecastResult {

    @SerializedName("location")
    private Location mLocation;
    @SerializedName("current")
    private Current mCurrent;
    @SerializedName("forecast")
    private Forecast mForecast;

    public Location getLocation() {
        return mLocation;
    }

    public void setLocation(Location location) {
        this.mLocation = location;
    }

    public Current getCurrent() {
        return mCurrent;
    }

    public void setCurrent(Current current) {
        this.mCurrent = current;
    }

    public Forecast getForecast() {
        return mForecast;
    }

    public void setForecast(Forecast forecast) {
        this.mForecast = forecast;
    }
}
