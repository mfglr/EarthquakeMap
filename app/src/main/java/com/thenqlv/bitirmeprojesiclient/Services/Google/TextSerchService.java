package com.thenqlv.bitirmeprojesiclient.Services.Google;

import com.thenqlv.bitirmeprojesiclient.Entities.Google.TextSearchModel;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface TextSerchService {
    @GET("json?")
    Call<TextSearchModel> get(@QueryMap Map<String, String> options);
}
