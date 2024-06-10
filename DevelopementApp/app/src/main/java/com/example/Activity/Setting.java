package com.example.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Setting extends AppCompatActivity {
    private ImageView setting_Home_iv;
    private ImageView setting_Al_iv;
    private ImageView setting_Msg_iv;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);


        setting_Home_iv = findViewById(R.id.setting_home_iv);
        setting_Msg_iv = findViewById(R.id.setting_msg_iv);
        setting_Al_iv = findViewById(R.id.setting_al_iv);


        setting_Home_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Setting.this,Home.class));
            }
        });
        setting_Msg_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Setting.this,Message.class));
            }
        });
        setting_Al_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Setting.this,ActionLibrary.class));
            }
        });
    }

    ;


}
