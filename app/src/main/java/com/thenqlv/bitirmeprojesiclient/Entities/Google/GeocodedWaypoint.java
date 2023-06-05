package com.thenqlv.bitirmeprojesiclient.Entities.Google;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GeocodedWaypoint implements Serializable {
    @SerializedName("geocoder_status")
    private String geocoder_status;
    @SerializedName("place_id")
    private String place_id;
    @SerializedName("types")
    private String[] types;

    public String getGeocoder_status() {
        return geocoder_status;
    }

    public String getPlace_id() {
        return place_id;
    }

    public String[] getTypes() {
        return types;
    }
}
