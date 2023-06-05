package com.thenqlv.bitirmeprojesiclient.Entities.Google;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Candidate implements Serializable {
    @SerializedName("business_status")
    private String businessStatus;
    @SerializedName("formatted_address")
    private String formattedAddress;
    @SerializedName("geometry")
    private Geometry geometry;
    @SerializedName("icon")
    private String icon;
    @SerializedName("icon_background_color")
    private String iconBackgroundColor;
    @SerializedName("icon_mask_base_uri")
    private String iconMaskBaseUri;
    @SerializedName("name")
    private String name;
    @SerializedName("opening_hours")
    private OpeningHours openingHours;
    @SerializedName("photos")
    private Photo[] photos;
    @SerializedName("place_id")
    private String placeId;
    @SerializedName("plus_code")
    private PlusCode plusCode;
    @SerializedName("price_level")
    private int priceLevel;
    @SerializedName("rating")
    private double rating;
    @SerializedName("types")
    private String[] types;
    @SerializedName("user_ratings_total")
    private int userRatingsTotal;

    public String getBusinessStatus() {
        return businessStatus;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public String getIcon() {
        return icon;
    }

    public String getIconBackgroundColor() {
        return iconBackgroundColor;
    }

    public String getIconMaskBaseUri() {
        return iconMaskBaseUri;
    }

    public String getName() {
        return name;
    }

    public Photo[] getPhotos() {
        return photos;
    }

    public String getPlaceId() {
        return placeId;
    }

    public OpeningHours getOpeningHours() {
        return openingHours;
    }

    public PlusCode getPlusCode() {
        return plusCode;
    }

    public int getPriceLevel() {
        return priceLevel;
    }

    public double getRating() {
        return rating;
    }

    public String[] getTypes() {
        return types;
    }

    public int getUserRatingsTotal() {
        return userRatingsTotal;
    }

}
