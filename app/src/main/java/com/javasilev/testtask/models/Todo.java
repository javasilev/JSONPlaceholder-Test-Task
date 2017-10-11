package com.javasilev.testtask.models;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings({"unused", "SpellCheckingInspection"})
public class Todo implements Serializable {

    @SerializedName("userId")
    private int mUserid;
    @SerializedName("id")
    private int mId;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("completed")
    private boolean mCompleted;

    public int getUserid() {
        return mUserid;
    }

    public void setUserid(int mUserid) {
        this.mUserid = mUserid;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public boolean getCompleted() {
        return mCompleted;
    }

    public void setCompleted(boolean mCompleted) {
        this.mCompleted = mCompleted;
    }
}
