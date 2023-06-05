package com.thenqlv.bitirmeprojesiclient.Entities.API;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Individual extends User implements Serializable {
    @SerializedName("name")
    private String name;

    @SerializedName("lastName")
    private String lastname;

    @SerializedName("diseases")
    private List<Disease> diseases;

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }
}
