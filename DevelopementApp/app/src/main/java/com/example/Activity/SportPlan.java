package com.example.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class SportPlan extends AppCompatActivity {
    private ImageView sp_Back_iv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sport_plan);
        sp_Back_iv=(ImageView) findViewById(R.id.sport_back_iv);
        sp_Back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SportPlan.this,Home.class));
                finish();
            }
        });
    }
}

