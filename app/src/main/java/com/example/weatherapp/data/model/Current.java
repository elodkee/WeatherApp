package com.example.weatherapp.data.model;

import com.google.gson.annotations.SerializedName;

public class Current {
    @SerializedName("last_updated_epoch")
    private long mLastUpdeEpoch;
    @SerializedName("last_updated")
    private String mLastUpdateTime;
    @SerializedName("temp_c")
    private int mTempCelsius;
    @SerializedName("temp_f")
    private String mTempF;
    @SerializedName("condition")
    private Condition mCondition;
    @SerializedName("wind_mph")
    private double mWindMPH;
    @SerializedName("wind_kph")
    private double mWindKPH;
    @SerializedName("precip_in")
    private double mPrecipition;
    @SerializedName("humidity")
    private double mHumidity;

    public long getLastUpdeEpoch() {
        return mLastUpdeEpoch;
    }

    public void setLastUpdeEpoch(long lastUpdeEpoch) {
        this.mLastUpdeEpoch = lastUpdeEpoch;
    }

    public String getLastUpdateTime() {
        return mLastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.mLastUpdateTime = lastUpdateTime;
    }

    public int getTempCelsius() {
        return mTempCelsius;
    }

    public void setTempCelsius(int tempCelsius) {
        this.mTempCelsius = tempCelsius;
    }

    public String getTempF() {
        return mTempF;
    }

    public void setTempF(String tempF) {
        this.mTempF = tempF;
    }

    public Condition getCondition() {
        return mCondition;
    }

    public void setCondition(Condition condition) {
        this.mCondition = condition;
    }

    public double getWindMPH() {
        return mWindMPH;
    }

    public void setWindMPH(double windMPH) {
        this.mWindMPH = windMPH;
    }

    public double getWindKPH() {
        return mWindKPH;
    }

    public void setWindKPH(double windKPH) {
        this.mWindKPH = windKPH;
    }

    public double getPrecipition() {
        return mPrecipition;
    }

    public void setPrecipition(double precipition) {
        this.mPrecipition = precipition;
    }

    public double getHumidity() {
        return mHumidity;
    }

    public void setHumidity(double humidity) {
        this.mHumidity = humidity;
    }
}
