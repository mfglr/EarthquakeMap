package com.thenqlv.bitirmeprojesiclient.Entities.Google;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Route implements Serializable {
    @SerializedName("bounds")
    private Viewport bounds;
    @SerializedName("copyrights")
    private String copyrights;
    @SerializedName("legs")
    private Leg[] legs;
    @SerializedName("overview_polyline")
    private Polyline overview_polyline;
    @SerializedName("summary")
    private String summary;

    public Viewport getBounds() {
        return bounds;
    }

    public String getCopyrights() {
        return copyrights;
    }

    public Leg[] getLegs() {
        return legs;
    }

    public Polyline getOverview_polyline() {
        return overview_polyline;
    }

    public String getSummary() {
        return summary;
    }
}
