package com.thenqlv.bitirmeprojesiclient.Services.Afad;

import com.thenqlv.bitirmeprojesiclient.Entities.Afad.Earthquake;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface EarthquakeService {
    @GET("filter?format=json")
    Call<List<Earthquake>> get(@QueryMap Map<String, String> options);
}
