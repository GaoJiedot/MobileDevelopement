package com.example.myapplication;

import static androidx.core.app.PendingIntentCompat.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fragment.HomeFragment;
import com.example.myapplication.databinding.LoginBinding;

public class Login extends AppCompatActivity {

    private  LoginBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=LoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phonenumber = binding.loginEt.getText().toString();
                boolean agreement = binding.loginCb.isChecked();

                if (phonenumber.length() < 11) {
                    Toast.makeText(Login.this, "请输入完整的手机号", Toast.LENGTH_SHORT).show();
                } else if (!agreement) {
                    Toast.makeText(Login.this, "未同意以上条款", Toast.LENGTH_SHORT).show();
                } else {

                 startActivity(new Intent(Login.this,MainActivity.class));
                 finish();
                }
            }
        });
        binding.exitIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);//正常退出
            }
        });
    }
}
