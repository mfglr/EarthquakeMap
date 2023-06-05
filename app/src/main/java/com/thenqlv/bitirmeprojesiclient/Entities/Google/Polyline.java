package com.thenqlv.bitirmeprojesiclient.Entities.Google;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Polyline implements Serializable {
    @SerializedName("points")
    private String points;

    public String getPoints() {
        return points;
    }
}
