package com.javasilev.testtask.models;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings({"WeakerAccess", "unused"})
public class User implements Serializable {

    @SerializedName("id")
    private int mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("username")
    private String mUsername;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("address")
    private Address mAddress;
    @SerializedName("phone")
    private String mPhone;
    @SerializedName("website")
    private String mWebsite;
    @SerializedName("company")
    private Company mCompany;

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

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public Address getAddress() {
        return mAddress;
    }

    public void setAddress(Address mAddress) {
        this.mAddress = mAddress;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getWebsite() {
        return mWebsite;
    }

    public void setWebsite(String mWebsite) {
        this.mWebsite = mWebsite;
    }

    public Company getCompany() {
        return mCompany;
    }

    public void setCompany(Company mCompany) {
        this.mCompany = mCompany;
    }

    @Override
    public String toString() {
        return "#" + getId() + ": " + getName() + " aka \"" + getUsername() + "\"";
    }
}
