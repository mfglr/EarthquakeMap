package com.thenqlv.bitirmeprojesiclient.Entities.API;

import com.google.gson.annotations.SerializedName;

public class Parent<T> {

    @SerializedName("data")
    private T data;

    public T getData() {
        return data;
    }
}
