package com.thenqlv.bitirmeprojesiclient.Entities.Google;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OpeningHours implements Serializable {
    @SerializedName("open_now")
    private boolean openNow;

    public boolean isOpeningNow() {
        return openNow;
    }


}
