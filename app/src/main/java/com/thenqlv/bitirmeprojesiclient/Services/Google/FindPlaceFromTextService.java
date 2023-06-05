package com.thenqlv.bitirmeprojesiclient.Services.Google;

import com.thenqlv.bitirmeprojesiclient.Entities.Google.FindPlaceFromTextModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface FindPlaceFromTextService {
    @GET("json?inputtype=textquery&fields=business_status," +
            "formatted_address," +
            "geometry," +
            "icon," +
            "icon_mask_base_uri," +
            "icon_background_color," +
            "name," +
            "photo," +
            "place_id," +
            "plus_code," +
            "type," +
            "opening_hours," +
            "price_level," +
            "rating," +
            "user_ratings_total&")
    Call<FindPlaceFromTextModel> get(@QueryMap Map<String, String> options);
}
