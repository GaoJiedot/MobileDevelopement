package com.example.service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @POST("api/users/avatar")
    Call<Void> updateAvatar(@Query("username") String username, @Query("avatarUrl") String avatarUrl);
//
//    @POST("api/posts")
//    Call<Post> createPost(@Body PostDTO postDTO);
//
//    @GET("api/posts")
//    Call<List<Post>> getAllPosts();
}