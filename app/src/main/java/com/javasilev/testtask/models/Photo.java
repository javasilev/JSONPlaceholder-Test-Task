package com.javasilev.testtask.models;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings({"unused", "SpellCheckingInspection"})
public class Photo implements Serializable {

    @SerializedName("albumId")
    private int mAlbumid;
    @SerializedName("id")
    private int mId;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("thumbnailUrl")
    private String mThumbnailurl;

    public int getAlbumid() {
        return mAlbumid;
    }

    public void setAlbumid(int mAlbumid) {
        this.mAlbumid = mAlbumid;
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

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    public String getThumbnailurl() {
        return mThumbnailurl;
    }

    public void setThumbnailurl(String mThumbnailurl) {
        this.mThumbnailurl = mThumbnailurl;
    }
}
