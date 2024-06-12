package com.example.Activity;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.databinding.BodydataBinding;


public class BodyData extends AppCompatActivity {

    private  BodydataBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding=BodydataBinding.inflate(getLayoutInflater());
         setContentView(binding.getRoot());

    }
}

