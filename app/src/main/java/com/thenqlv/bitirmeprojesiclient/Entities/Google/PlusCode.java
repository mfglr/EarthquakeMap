package com.thenqlv.bitirmeprojesiclient.Entities.Google;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PlusCode implements Serializable {
    @SerializedName("compound_code")
    private String compoundCode;
    @SerializedName("global_code")
    private String globalCode;

    public String getCompoundCode() {
        return compoundCode;
    }

    public String getGlobalCode() {
        return globalCode;
    }


}
