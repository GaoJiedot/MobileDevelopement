package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.fragment.HomeFragment;
import com.example.fragment.MessageFragment;
import com.example.fragment.SettingFragment;
import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
  private ImageView Home;
  private ImageView Al;
  private ImageView Msg;
  private ImageView My;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Home=findViewById(R.id.home);
        Msg=findViewById(R.id.msg);
        My=findViewById(R.id.my);

        loadDefaultFragment();
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragment homeFragment =new HomeFragment();
                FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fg,homeFragment);
                transaction.commit();
            }
        });
        Msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessageFragment messageFragment =new MessageFragment();
                FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fg,messageFragment);
                transaction.commit();
            }
        });
        My.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingFragment settingFragment =new SettingFragment();
                FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fg,settingFragment);
                transaction.commit();
            }
        });
    }

    private void loadDefaultFragment() {
        HomeFragment homeFragment =new HomeFragment();
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fg,homeFragment);
        transaction.commit();
    }

}
