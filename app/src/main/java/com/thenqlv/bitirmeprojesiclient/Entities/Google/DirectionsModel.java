package com.thenqlv.bitirmeprojesiclient.Entities.Google;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DirectionsModel implements Serializable {

    @SerializedName("geocoded_waypoints")
    private GeocodedWaypoint[] geocoded_waypoints;

    @SerializedName("routes")
    private Route[] routes;

    @SerializedName("status")
    private String status;

    public GeocodedWaypoint[] getGeocoded_waypoints() {
        return geocoded_waypoints;
    }

    public Route[] getRoutes() {
        return routes;
    }

    public String getStatus() {
        return status;
    }
}
