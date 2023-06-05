package com.thenqlv.bitirmeprojesiclient.Entities.API;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Disease extends BaseModel implements Serializable {
    @SerializedName("name")
    private String name;

    @SerializedName("individuals")
    private List<Individual> individuals;

    @SerializedName("products")
    private List<Product> products;

    public String getName() {
        return name;
    }

    public List<Individual> getIndividuals() {
        return individuals;
    }

    public List<Product> getProducts() {
        return products;
    }
}
