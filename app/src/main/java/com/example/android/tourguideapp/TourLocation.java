package com.example.android.tourguideapp;

import androidx.annotation.NonNull;

public class TourLocation {

    private String mName;
    private int mThumbnailResourceID;

    public TourLocation(String name, int thumbnailResourceID){
        mName = name;
        mThumbnailResourceID = thumbnailResourceID;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getThumbnailResourceID() {
        return mThumbnailResourceID;
    }

    public void setThumbnail(int thumbnailResourceID) {
        mThumbnailResourceID = thumbnailResourceID;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mThumbnailResourceID='" + mThumbnailResourceID + '\'' +
                ", location='" + mName + '\'' +
                '}';
    }
}
