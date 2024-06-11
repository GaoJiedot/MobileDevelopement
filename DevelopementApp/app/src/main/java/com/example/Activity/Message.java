package com.example.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Message extends AppCompatActivity {


    private ImageView message_Home_iv;
    private ImageView message_Al_iv;
    private ImageView message_MY_iv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);

        message_Home_iv=(ImageView) findViewById(R.id.message_home_iv);
        message_Al_iv=(ImageView) findViewById(R.id.message_al_iv);
        message_MY_iv=(ImageView) findViewById(R.id.message_my_iv);

        message_Home_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Message.this,Home.class));
                finish();
            }
        });
        message_MY_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Message.this,Setting.class));
                finish();
            }
        });
        message_Al_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Message.this,ActionLibrary.class));
                finish();
            }
        });
    }
}
