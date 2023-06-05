package com.thenqlv.bitirmeprojesiclient.Entities.API;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;
import com.thenqlv.bitirmeprojesiclient.Entities.Google.Location;

import java.io.Serializable;
import java.util.List;

public class MusterPoint extends BaseModel implements Serializable {
    @SerializedName("name")
    private String name;

    @SerializedName("city")
    private String city;

    @SerializedName("district")
    private String district;

    @SerializedName("latitude")
    private double latitude;

    @SerializedName("longitude")
    private double longitude;

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Location getLocation(){
        return new Location(latitude,longitude);
    }
    public LatLng getLatLng(){
        return new LatLng(latitude,longitude);
    }


    public static LatLng[] getLatLngListFromMusterPointList(List<MusterPoint> musterPoints){
        LatLng[] list = new LatLng[musterPoints.size()];
        for(int i = 0; i < musterPoints.size(); i++)
            list[i] = musterPoints.get(i).getLatLng();
        return  list;
    }
}
