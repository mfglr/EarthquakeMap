package com.thenqlv.bitirmeprojesiclient.Entities.Google;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Leg implements Serializable {
    @SerializedName("distance")
    private Distance distance;
    @SerializedName("duration")
    private Duration duration;
    @SerializedName("end_address")
    private String end_address;
    @SerializedName("end_location")
    private Location end_location;
    @SerializedName("start_address")
    private String start_address;
    @SerializedName("start_location")
    private Location start_location;
    @SerializedName("steps")
    private Step[] steps;

    public Distance getDistance() {
        return distance;
    }

    public Duration getDuration() {
        return duration;
    }

    public String getEnd_address() {
        return end_address;
    }

    public Location getEnd_location() {
        return end_location;
    }

    public String getStart_address() {
        return start_address;
    }

    public Location getStart_location() {
        return start_location;
    }

    public Step[] getSteps() {
        return steps;
    }
}
