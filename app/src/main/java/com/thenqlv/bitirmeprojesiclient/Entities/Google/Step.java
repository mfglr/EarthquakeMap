package com.thenqlv.bitirmeprojesiclient.Entities.Google;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Step implements Serializable {
    @SerializedName("distance")
    private Distance distance;
    @SerializedName("duration")
    private Distance duration;
    @SerializedName("end_location")
    private Location end_location;
    @SerializedName("html_instructions")
    private String html_instructions;
    @SerializedName("polyline")
    private Polyline polyline;
    @SerializedName("start_location")
    private Location start_location;
    @SerializedName("travel_mode")
    private String travel_mode;

    public Distance getDistance() {
        return distance;
    }

    public Distance getDuration() {
        return duration;
    }

    public Location getEnd_location() {
        return end_location;
    }

    public String getHtml_instructions() {
        return html_instructions;
    }

    public Polyline getPolyline() {
        return polyline;
    }

    public Location getStart_location() {
        return start_location;
    }

    public String getTravel_mode() {
        return travel_mode;
    }
}
