package com.javasilev.testtask.models;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings({"WeakerAccess", "unused", "SpellCheckingInspection"})
public class Address implements Serializable {
    @SerializedName("street")
    private String mStreet;
    @SerializedName("suite")
    private String mSuite;
    @SerializedName("city")
    private String mCity;
    @SerializedName("zipcode")
    private String mZipcode;
    @SerializedName("geo")
    private Geo mGeo;

    public String getStreet() {
        return mStreet;
    }

    public void setStreet(String mStreet) {
        this.mStreet = mStreet;
    }

    public String getSuite() {
        return mSuite;
    }

    public void setSuite(String mSuite) {
        this.mSuite = mSuite;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String mCity) {
        this.mCity = mCity;
    }

    public String getZipcode() {
        return mZipcode;
    }

    public void setZipcode(String mZipcode) {
        this.mZipcode = mZipcode;
    }

    public Geo getGeo() {
        return mGeo;
    }

    public void setGeo(Geo mGeo) {
        this.mGeo = mGeo;
    }
}
