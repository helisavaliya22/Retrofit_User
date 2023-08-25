package com.example.retrofit_user;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Retro_Interface {

    @GET("users")
    Call<List<ViewProduct>> showProducts();
}
