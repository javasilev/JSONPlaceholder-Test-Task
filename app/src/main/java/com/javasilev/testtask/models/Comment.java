package com.javasilev.testtask.models;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings({"unused", "SpellCheckingInspection"})
public class Comment implements Serializable {

    @SerializedName("postId")
    private int mPostid;
    @SerializedName("id")
    private int mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("body")
    private String mBody;

    public int getPostid() {
        return mPostid;
    }

    public void setPostid(int mPostid) {
        this.mPostid = mPostid;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getBody() {
        return mBody;
    }

    public void setBody(String mBody) {
        this.mBody = mBody;
    }
}
