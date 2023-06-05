package com.thenqlv.bitirmeprojesiclient.Entities.API;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Category extends BaseModel implements Serializable {
    @SerializedName("name")
    private String name;

    @SerializedName("products")
    private List<Product> product;

}
