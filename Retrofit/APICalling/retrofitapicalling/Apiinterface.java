package com.example.retrofitapicalling;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;

public interface Apiinterface
{
    @GET("marvel/")
    Call<List<RetrofitModel>>getdata();
}
