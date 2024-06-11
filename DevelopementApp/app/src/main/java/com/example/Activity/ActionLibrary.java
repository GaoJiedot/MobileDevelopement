package com.example.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.Item.ListItem;
import com.example.adapter.ListAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ActionLibrary extends AppCompatActivity {
    private ImageView al_Home_iv;
    private ImageView al_Msg_iv;
    private ImageView al_My_iv;
    private String[] data = {"全部运动", "胸部", "手臂", "背部", "腿部", "臀部"};
    private List<ListItem> itemList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actionlibrary);

        al_Home_iv=(ImageView) findViewById(R.id.al_home_iv);
        al_Msg_iv=(ImageView) findViewById(R.id.al_msg_iv);
        al_My_iv=(ImageView) findViewById(R.id.al_my_iv);


        al_Home_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActionLibrary.this,Home.class));
                finish();
            }
        });
        al_Msg_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActionLibrary.this,Message.class));
                finish();
            }
        });
        al_My_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActionLibrary.this,Setting.class));
                finish();
            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<>(ActionLibrary.this, R.layout.list_layout1, data);
        ListView listView = (ListView) findViewById(R.id.al_lv);
        listView.setAdapter(adapter);
        populateItemList();
        ListAdapter listAdapter = new ListAdapter(this, R.layout.list_layout2, itemList);
        ListView imageListView = findViewById(R.id.al_lv2);
        imageListView.setAdapter(listAdapter);
    }

    private void populateItemList() {
        itemList.add(new ListItem(R.drawable.ic_launcher_foreground, "俯卧撑", "肱三头肌，胸肌中下束"));
        itemList.add(new ListItem(R.drawable.ic_launcher_foreground, "跪姿半程俯卧撑","肱三头肌，胸肌中下束"));
        itemList.add(new ListItem(R.drawable.ic_launcher_foreground, "上斜俯卧撑","肱三头肌，胸肌中下束"));
        itemList.add(new ListItem(R.drawable.ic_launcher_foreground, "引体向上","背阔肌，肱二头肌"));
        itemList.add(new ListItem(R.drawable.ic_launcher_foreground, "深蹲","股四头肌，臀大肌"));
        itemList.add(new ListItem(R.drawable.ic_launcher_foreground, "俯身哑铃划船","dasdadsa"));
        itemList.add(new ListItem(R.drawable.ic_launcher_foreground, "俯身哑铃划船","dasdadsa"));
        itemList.add(new ListItem(R.drawable.ic_launcher_foreground, "俯身哑铃划船","dasdadsa"));
        itemList.add(new ListItem(R.drawable.ic_launcher_foreground, "俯身哑铃划船","dasdadsa"));
        itemList.add(new ListItem(R.drawable.ic_launcher_foreground, "俯身哑铃划船","dasdadsa"));
        itemList.add(new ListItem(R.drawable.ic_launcher_foreground, "俯身哑铃划船","dasdadsa"));
    }

}
