package com.thenqlv.bitirmeprojesiclient.Services.API;

import com.thenqlv.bitirmeprojesiclient.Entities.API.MusterPoint;
import com.thenqlv.bitirmeprojesiclient.Entities.API.Parent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MusterPointService {


    @GET("musterpoint/getbycity/{city}")
    public Call<Parent<List<MusterPoint>>> getByCity(@Path("city") String city);
}
