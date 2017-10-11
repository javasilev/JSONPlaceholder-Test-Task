package com.javasilev.testtask.models;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings({"WeakerAccess", "unused"})
public class Company implements Serializable {
    @SerializedName("name")
    private String mName;
    @SerializedName("catchPhrase")
    private String mCatchphrase;
    @SerializedName("bs")
    private String mBs;

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getCatchphrase() {
        return mCatchphrase;
    }

    public void setCatchphrase(String mCatchphrase) {
        this.mCatchphrase = mCatchphrase;
    }

    public String getBs() {
        return mBs;
    }

    public void setBs(String mBs) {
        this.mBs = mBs;
    }
}
