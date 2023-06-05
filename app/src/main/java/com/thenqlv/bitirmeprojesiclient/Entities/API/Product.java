package com.thenqlv.bitirmeprojesiclient.Entities.API;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Product extends BaseModel implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("businesses")
    private List<Business> businesses;

    @SerializedName("categories")
    private List<Category> categories;

    @SerializedName("components")
    private List<Product> components;

    @SerializedName("dieases")
    private List<Disease> diseases;

    public String getName() {
        return name;
    }

    public List<Business> getBusinesses() {
        return businesses;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<Product> getComponents() {
        return components;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }
}
