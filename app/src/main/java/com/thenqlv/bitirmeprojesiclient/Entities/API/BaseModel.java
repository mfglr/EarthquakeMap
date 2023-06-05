package com.thenqlv.bitirmeprojesiclient.Entities.API;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BaseModel implements Serializable {
    @SerializedName("id")
    private int id;

    public int getId() {
        return id;
    }
}
