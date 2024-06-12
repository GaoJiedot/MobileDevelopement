package com.example.Activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.CookbookBinding;

public class CookBook extends AppCompatActivity {

    private CookbookBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=CookbookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}