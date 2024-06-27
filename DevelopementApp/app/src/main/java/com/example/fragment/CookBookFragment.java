package com.example.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapter.RecipeAdapter;
import com.example.api.RecipeService;
import com.example.model.RecipeResponse;
import com.example.model.RecipeResult;
import com.example.myapplication.databinding.CookbookBinding;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CookBookFragment extends Fragment {

    private CookbookBinding binding;
    private static final String BASE_URL = "http://apis.juhe.cn/fapigx/caipu/";
    private static final String API_KEY = "ba027eaee219ff45d6389a6b7366234a";
    private RecipeAdapter recipeAdapter;
    private List<RecipeResult> recipeList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = CookbookBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        binding.cookbookBackIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null) {
                    getActivity().getSupportFragmentManager().popBackStack();
                }
            }
        });
        binding.searchBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = binding.foodEt.getText().toString().trim();
                if (!inputText.isEmpty()) {
                    fetchRecipes(inputText);
                } else {
                    // 可以在这里添加一些提示，比如显示一个Toast消息
                    Toast.makeText(getContext(), "请输入搜索关键词", Toast.LENGTH_SHORT).show();
                }
            }
        });

        RecyclerView recyclerView = binding.recipeRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recipeAdapter = new RecipeAdapter(recipeList);
        recyclerView.setAdapter(recipeAdapter);
        return view;
    }

    private void fetchRecipes(String menu) {
        // 确保关键字有效且长度适当
        if (menu == null || menu.trim().isEmpty() || menu.length() > 100) {
            Log.e("CookBookFragment", "Invalid menu keyword");
            return;
        }

        Log.d("CookBookFragment", "Fetching recipes with keyword: " + menu);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RecipeService service = retrofit.create(RecipeService.class);
        Call<RecipeResponse> call = service.getRecipes(API_KEY, menu);

        call.enqueue(new Callback<RecipeResponse>() {
            @Override
            public void onResponse(Call<RecipeResponse> call, Response<RecipeResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("CookBookFragment", "Response body: " + response.body().toString());
                    List<RecipeResult> results = response.body().getResult();
                    if (results != null) {
                        recipeList.clear();
                        recipeList.addAll(results);
                        recipeAdapter.notifyDataSetChanged();
                    } else {
                        Log.e("CookBookFragment", "No recipes found");
                    }
                } else {
                    Log.e("CookBookFragment", "Failed to fetch recipes: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<RecipeResponse> call, Throwable t) {
                Log.e("CookBookFragment", "API call failed", t);
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
