package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.MyData;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Action extends AppCompatActivity {

    private TextView textView;
    private TextView textView2;
    private VideoView video;
    private Button btn;
    String inputText;
    String itemName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action1);

        textView = findViewById(R.id.title_tv);
        textView2 = findViewById(R.id.dc_tv);
        video = findViewById(R.id.video);
        btn = findViewById(R.id.playbutton); // 这里要赋值给 btn

        Intent intent = getIntent();
        inputText = intent.getStringExtra("inputText");
        Intent intent2 = getIntent();
        itemName = intent2.getStringExtra("itemName");
        if (inputText != null){
            textView.setText(inputText);

            // 从 assets 目录下的 data.json 文件中读取数据
            String json = loadJSONFromAsset("data.json");

            // 解析 JSON 数据
            Gson gson = new Gson();
            MyData[] dataArray = gson.fromJson(json, MyData[].class);

            // 查找与 inputText 匹配的数据项
            MyData selectedData = null;
            for (MyData data : dataArray) {
                if (data.getTitle().equals(inputText)) {
                    selectedData = data;
                    break;
                }
            }

            // 更新 textView2 和 video
            if (selectedData != null) {
                textView2.setText(selectedData.getDescription());
                video.setVideoPath(selectedData.getVideoUrl());
            }
        }
        if (itemName != null){
            textView.setText(itemName);

            // 从 assets 目录下的 data.json 文件中读取数据
            String json = loadJSONFromAsset("data.json");

            // 解析 JSON 数据
            Gson gson = new Gson();
            MyData[] dataArray = gson.fromJson(json, MyData[].class);

            // 查找与 inputText 匹配的数据项
            MyData selectedData = null;
            for (MyData data : dataArray) {
                if (data.getTitle().equals(itemName)) {
                    selectedData = data;
                    break;
                }
            }

            // 更新 textView2 和 video
            if (selectedData != null) {
                textView2.setText(selectedData.getDescription());
                video.setVideoPath(selectedData.getVideoUrl());
            }
        }



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                video.start();
            }
        });
    }

    private String loadJSONFromAsset(String filename) {
        String json = null;
        try {
            InputStream is = getAssets().open(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();
            json = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
