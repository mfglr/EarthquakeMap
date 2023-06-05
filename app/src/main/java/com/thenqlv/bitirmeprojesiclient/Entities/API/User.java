package com.thenqlv.bitirmeprojesiclient.Entities.API;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User extends BaseModel implements Serializable {
    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    @SerializedName("email")
    private String email;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
