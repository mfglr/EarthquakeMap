package com.thenqlv.bitirmeprojesiclient.Entities.Google;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Location implements  Serializable{
    @SerializedName("lat")
    private double latitude;
    @SerializedName("lng")
    private double longitude;

    public Location(double latitude,double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public LatLng getLatLng(){
        return new LatLng(latitude,longitude);
    }

    public static Location getLocationFromLatLng(LatLng latLng){
        return new Location(latLng.latitude,latLng.longitude);
    }
}
