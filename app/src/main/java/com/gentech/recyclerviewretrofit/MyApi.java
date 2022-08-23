package com.gentech.recyclerviewretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {

    @GET("adminAllPolicyDetails")
    Call<List<ResponseArray>> getData();



}