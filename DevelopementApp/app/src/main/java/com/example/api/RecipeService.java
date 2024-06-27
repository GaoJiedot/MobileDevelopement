package com.example.api;

import com.example.model.RecipeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeService {
    @GET("query")
    Call<RecipeResponse> getRecipes(@Query("key") String apiKey, @Query("menu") String menu);
}
