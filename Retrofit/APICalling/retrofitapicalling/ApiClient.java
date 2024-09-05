package com.example.retrofitapicalling;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String base_url="https://simplifiedcoding.net/demos/";
    private static Retrofit retrofit;

    public static Retrofit getApi(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
