package com.javasilev.testtask.models;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings({"WeakerAccess", "unused"})
public class Geo {
    @SerializedName("lat")
    private String mLat;
    @SerializedName("lng")
    private String mLng;

    public String getLat() {
        return mLat;
    }

    public void setLat(String mLat) {
        this.mLat = mLat;
    }

    public String getLng() {
        return mLng;
    }

    public void setLng(String mLng) {
        this.mLng = mLng;
    }
}
