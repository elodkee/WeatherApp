package com.example.weatherapp.data.model;

import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("name")
    private String mCityName;
    @SerializedName("region")
    private String mRegio;
    @SerializedName("country")
    private String mCountry;
    @SerializedName("lat")
    private double mLatitude;
    @SerializedName("lon")
    private double mLongitude;
    @SerializedName("tz_id")
    private String mTimeZone;
    @SerializedName("localtime_epoch")
    private long mLocalTimeMillisecund;
    @SerializedName("localtime")
    private String mLocalTime;

    public String getCityName() {
        return mCityName;
    }

    public void setCityName(String cityName) {
        this.mCityName = cityName;
    }

    public String getRegio() {
        return mRegio;
    }

    public void setRegio(String regio) {
        this.mRegio = regio;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        this.mCountry = country;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public void setLatitude(double latitude) {
        this.mLatitude = latitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public void setLongitude(double longitude) {
        this.mLongitude = longitude;
    }

    public String getTimeZone() {
        return mTimeZone;
    }

    public void setTimeZone(String timeZone) {
        this.mTimeZone = timeZone;
    }

    public long getLocalTimeMillisecund() {
        return mLocalTimeMillisecund;
    }

    public void setLocalTimeMillisecund(long localTimeMillisecund) {
        this.mLocalTimeMillisecund = localTimeMillisecund;
    }

    public String getLocalTime() {
        return mLocalTime;
    }

    public void setLocalTime(String localTime) {
        this.mLocalTime = localTime;
    }
}
