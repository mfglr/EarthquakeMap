package com.thenqlv.bitirmeprojesiclient.Entities.Afad;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Earthquake implements Serializable {
    @SerializedName("eventID")
    private int eventID;
    @SerializedName("latitude")
    private double latitude;
    @SerializedName("longitude")
    private double longitude;

    @SerializedName("location")
    private String location;
    @SerializedName("depth")
    private double depth;
    @SerializedName("type")
    private String type;
    @SerializedName("magnitude")
    private double magnitude;
    @SerializedName("province")
    private String country;
    @SerializedName("district")
    private String district;
    @SerializedName("neighborhood")
    private String neighborhood;
    @SerializedName("date")
    private String date;

    public int getEventID() {
        return eventID;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getLocation() {
        return location;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getDepth() {
        return depth;
    }

    public String getType() {
        return type;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getCountry() {
        return country;
    }

    public String getDistrict() {
        return district;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getDate() {
        return date;
    }


    public LatLng getLatLng(){
        return new LatLng(latitude,longitude);
    }
}

