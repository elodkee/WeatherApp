package com.example.weatherapp.data.model;

import com.google.gson.annotations.SerializedName;

public class Day {

    @SerializedName("maxtemp_c")
    private float maxtemp_c;
    @SerializedName("maxtemp_f")
    private float maxtemp_f;
    @SerializedName("mintemp_c")
    private float mintemp_c;
    @SerializedName("mintemp_f")
    private float mintemp_f;
    @SerializedName("avgtemp_c")
    private float avgtemp_c;
    @SerializedName("avgtemp_f")
    private float avgtemp_f;
    @SerializedName("maxwind_mph")
    private float maxwind_mph;
    @SerializedName("maxwind_kph")
    private float maxwind_kph;
    @SerializedName("condition")
    private Condition condition;

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    // Getter Methods

    public float getMaxtemp_c() {
        return maxtemp_c;
    }

    public float getMaxtemp_f() {
        return maxtemp_f;
    }

    public float getMintemp_c() {
        return mintemp_c;
    }

    public float getMintemp_f() {
        return mintemp_f;
    }

    public float getAvgtemp_c() {
        return avgtemp_c;
    }

    public float getAvgtemp_f() {
        return avgtemp_f;
    }

    public float getMaxwind_mph() {
        return maxwind_mph;
    }

    public float getMaxwind_kph() {
        return maxwind_kph;
    }

    // Setter Methods

    public void setMaxtemp_c(float maxtemp_c) {
        this.maxtemp_c = maxtemp_c;
    }

    public void setMaxtemp_f(float maxtemp_f) {
        this.maxtemp_f = maxtemp_f;
    }

    public void setMintemp_c(float mintemp_c) {
        this.mintemp_c = mintemp_c;
    }

    public void setMintemp_f(float mintemp_f) {
        this.mintemp_f = mintemp_f;
    }

    public void setAvgtemp_c(float avgtemp_c) {
        this.avgtemp_c = avgtemp_c;
    }

    public void setAvgtemp_f(float avgtemp_f) {
        this.avgtemp_f = avgtemp_f;
    }

    public void setMaxwind_mph(float maxwind_mph) {
        this.maxwind_mph = maxwind_mph;
    }

    public void setMaxwind_kph(float maxwind_kph) {
        this.maxwind_kph = maxwind_kph;
    }

}
