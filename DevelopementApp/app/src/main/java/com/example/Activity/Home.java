package com.example.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class Home extends AppCompatActivity {
    private ImageView food_Iv;
    private ImageView lB_iv;
    private ImageView bodyData_iv;
    private ImageView sportPlan_iv;
    private ImageView home_My_iv;
    private ImageView home_Msg_iv;
    private ImageView home_Al_iv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        food_Iv = (ImageView) findViewById(R.id.food_iv);
        lB_iv = (ImageView) findViewById(R.id.lb_iv);
        bodyData_iv=(ImageView) findViewById(R.id.bodydata_iv);
        sportPlan_iv=(ImageView) findViewById(R.id.sportplan_iv);
        home_My_iv=(ImageView) findViewById(R.id.home_my_iv);
        home_Msg_iv=(ImageView) findViewById(R.id.home_msg_iv);
        home_Al_iv=(ImageView) findViewById(R.id.home_al_iv);




        food_Iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, CookBook.class));
            }
        });

        lB_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, ActionLibrary.class));
            }
        });

        bodyData_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,BodyData.class));
            }
        });
        sportPlan_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, SportPlan.class));
            }
        });
        home_My_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,Setting.class));
            }
        });
        home_Msg_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,Message.class));
            }
        });
        home_Al_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,ActionLibrary.class));
            }
        });
    }

    ;
}
