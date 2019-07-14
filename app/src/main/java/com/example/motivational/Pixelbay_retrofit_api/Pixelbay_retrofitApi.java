package com.example.motivational.Pixelbay_retrofit_api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Pixelbay_retrofitApi {

    public static final String BASE_URL="https://pixabay.com";
    public static Retrofit retrofit=null;

    public static Retrofit link_RetrofitApi(){

        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
