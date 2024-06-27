package com.example.api;

import com.example.model.VideoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VideoService {
    @GET("billboard")
    Call<VideoResponse> getVideoList(@Query("key") String apiKey);
}
