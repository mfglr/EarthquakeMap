package com.thenqlv.bitirmeprojesiclient.Entities.API;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Address extends BaseModel implements Serializable {
    @SerializedName("placeId")
    private String placeId;

    @SerializedName("business")
    private Business business;

    public String getPlaceId() {
        return placeId;
    }

    public Business getBusiness() {
        return business;
    }
}
