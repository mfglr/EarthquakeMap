package com.thenqlv.bitirmeprojesiclient.Entities.Google;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TextSearchModel implements Serializable {
    @SerializedName("html_attributions")
    private String[] htmlAttributions;

    @SerializedName("next_page_token")
    private String nextPageToken;

    @SerializedName("results")
    private Candidate[] results;

    @SerializedName("status")
    private String status;

    public String[] getHtmlAttributions() {
        return htmlAttributions;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public Candidate[] getResults() {
        return results;
    }

    public String getStatus() {
        return status;
    }
}
