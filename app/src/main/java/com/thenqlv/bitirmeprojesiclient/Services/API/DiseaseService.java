package com.thenqlv.bitirmeprojesiclient.Services.API;

import com.thenqlv.bitirmeprojesiclient.Entities.API.Disease;
import com.thenqlv.bitirmeprojesiclient.Entities.API.Parent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DiseaseService {

    @GET("disease/getbyname/{name}")
    Call<Parent<List<Disease>>> getByName(@Path("name") String name);
}
