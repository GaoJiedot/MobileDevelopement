package com.example.api;

import com.example.model.BMIResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BMIService {
    @GET("fapig/calculator/weight")
    Call<BMIResponse> getWeightData(@Query("key") String apiKey, @Query("height") int height, @Query("weight") int weight);
    }