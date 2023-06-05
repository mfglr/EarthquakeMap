package com.thenqlv.bitirmeprojesiclient.Entities.Google;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Geometry implements Serializable {
    @SerializedName("location")
    private Location location;
    @SerializedName("viewport")
    private Viewport viewport;
    public Location getLocation() {
        return location;
    }
    public Viewport getViewport() {
        return viewport;
    }

}
