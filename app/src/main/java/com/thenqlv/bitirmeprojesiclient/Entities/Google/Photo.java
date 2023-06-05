package com.thenqlv.bitirmeprojesiclient.Entities.Google;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Photo implements Serializable {

    @SerializedName("height")
    private int height;

    @SerializedName("html_attributions")
    private String[] htmlAttributions;

    @SerializedName("photo_reference")
    private String photoReference;

    @SerializedName("width")
    private int width;

    public int getHeight() {
        return height;
    }

    public String[] getHtmlAttributions() {
        return htmlAttributions;
    }

    public String getPhotoReference() {
        return photoReference;
    }

    public int getWidth() {
        return width;
    }


}
