package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
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

public class CookBook extends AppCompatActivity {

    private CookbookBinding binding;
    private static final String BASE_URL = "http://apis.juhe.cn/fapigx/caipu/";
    private static final String API_KEY = "ba027eaee219ff45d6389a6b7366234a";
    private RecipeAdapter recipeAdapter;
    private List<RecipeResult> recipeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = CookbookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.cookbookBackIv.setOnClickListener(v -> onBackPressed());

        binding.searchBtn2.setOnClickListener(v -> {
            String inputText = binding.foodEt.getText().toString().trim();
            if (!inputText.isEmpty()) {
                fetchRecipes(inputText);
            } else {
                Toast.makeText(this, "请输入搜索关键词", Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView recyclerView = binding.recipeRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recipeAdapter = new RecipeAdapter(recipeList);
        recyclerView.setAdapter(recipeAdapter);
    }

    private void fetchRecipes(String menu) {
        // ... 保持不变
    }

    private void showError(String message) {
        runOnUiThread(() -> Toast.makeText(this, message, Toast.LENGTH_SHORT).show());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}