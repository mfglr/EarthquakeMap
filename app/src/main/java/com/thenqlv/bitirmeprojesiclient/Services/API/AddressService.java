package com.thenqlv.bitirmeprojesiclient.Services.API;

import com.thenqlv.bitirmeprojesiclient.Entities.API.Address;
import com.thenqlv.bitirmeprojesiclient.Entities.API.Parent;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AddressService {
    @GET("address/getwithbusinesswithproductsbyplaceid/{placeId}")
    Call<Parent<Address>> getWithBusinessWithProductsByPlaceId(@Path("placeId") String placeId);
}
