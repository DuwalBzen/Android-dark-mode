package com.example.motivational.Pixelbay_retrofit_api;

import com.example.motivational.Model.pixel_bay_api_model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Pixelbay_request_api {

    @GET("/api/")
    Call<pixel_bay_api_model> getSearchImages(@Query("key") String api, @Query("category") String search, @Query("per_page") int no);
}
