package com.thenqlv.bitirmeprojesiclient.Entities.Google;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Duration  implements Serializable {
    @SerializedName("text")
    private String text;
    @SerializedName("value")
    private String value;

    public String getText() {
        return text;
    }

    public String getValue() {
        return value;
    }
}
