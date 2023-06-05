package com.thenqlv.bitirmeprojesiclient.Services.Google;

import com.thenqlv.bitirmeprojesiclient.Entities.Google.DirectionsModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface DirectionsService {
    @GET("json?")
    Call<DirectionsModel> get(@QueryMap Map<String, String> options);
}
