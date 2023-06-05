package com.thenqlv.bitirmeprojesiclient.Entities.Google;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FindPlaceFromTextModel implements Serializable {
    @SerializedName("candidates")
    private Candidate[] candidates;
    @SerializedName("status")
    private String status;
    public Candidate[] getCandidates() {
        return candidates;
    }
    public String getStatus() {
        return status;
    }
}
