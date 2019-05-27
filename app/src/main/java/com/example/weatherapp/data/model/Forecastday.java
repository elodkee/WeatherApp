package com.example.weatherapp.data.model;

import com.google.gson.annotations.SerializedName;

public class Forecastday {

    @SerializedName("date")
    private String mDate;
    @SerializedName("date_epoch")
    private long mDateEpoch;
    @SerializedName("day")
    private Day mDay;

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        this.mDate = date;
    }

    public long getDateEpoch() {
        return mDateEpoch;
    }

    public void setDateEpoch(long dateEpoch) {
        this.mDateEpoch = dateEpoch;
    }

    public Day getDay() {
        return mDay;
    }

    public void setDay(Day day) {
        this.mDay = day;
    }
}
