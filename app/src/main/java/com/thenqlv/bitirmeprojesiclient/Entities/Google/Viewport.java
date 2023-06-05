package com.thenqlv.bitirmeprojesiclient.Entities.Google;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Viewport implements Serializable {
    @SerializedName("northeast")
    private Location northeast;
    @SerializedName("southwest")
    private Location southwest;
    public Location getNortheast() {
        return northeast;
    }

    public Location getSouthwest() {
        return southwest;
    }

}
