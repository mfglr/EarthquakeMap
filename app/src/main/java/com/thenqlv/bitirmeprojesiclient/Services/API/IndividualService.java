package com.thenqlv.bitirmeprojesiclient.Services.API;

import com.thenqlv.bitirmeprojesiclient.Entities.API.Disease;
import com.thenqlv.bitirmeprojesiclient.Entities.API.Individual;
import com.thenqlv.bitirmeprojesiclient.Entities.API.Parent;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IndividualService {

    @GET("individual/getbyusername/{username}")
    Call<Parent<Individual>> getByUsername(@Path("username") String username);

    @GET("individual/getwithdiseaseswithproductsbyusername/{username}")
    Call<Parent<Individual>> getWithDiseasesWithProductsByUsername(@Path("username") String username);

    @GET("individual/getwithdiseasesbyid/{id}")
    Call<Parent<Individual>> getWithDiseasesById(@Path("id") int id);

    @PUT("individual/adddiseasebyid/{id}")
    Call<Parent<Individual>> addDiseaseById(@Path("id") int id,@Body Disease disease);
}
