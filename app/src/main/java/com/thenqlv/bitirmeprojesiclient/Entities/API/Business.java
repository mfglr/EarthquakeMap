package com.thenqlv.bitirmeprojesiclient.Entities.API;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Business extends User implements Serializable {
    @SerializedName("name")
    private String name;

    @SerializedName("address")
    private Address address;

    @SerializedName("products")
    private List<Product> products;


    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public List<Product> getProducts() {
        return products;
    }
}
