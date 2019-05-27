package com.example.weatherapp.data.model;

import com.google.gson.annotations.SerializedName;

public class Condition {

    @SerializedName("text")
    private String mText;
    @SerializedName("icon")
    private String mImageUrl;
    @SerializedName("code")
    private int mCode;

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        this.mText = text;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.mImageUrl = imageUrl;
    }

    public int getCode() {
        return mCode;
    }

    public void setCode(int code) {
        this.mCode = code;
    }
}
