package com.example.Activity;

import static androidx.core.app.PendingIntentCompat.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.LoginFilter;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.fragment.ActionLibraryFragment;
import com.example.fragment.HomeFragment;
import com.example.fragment.MessageFragment;
import com.example.fragment.SettingFragment;
import com.example.myapplication.R;
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
                    // 创建 HomeFragment 的实例
                    Fragment homeFragment = new HomeFragment();

                    // 开启 Fragment 事务
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                    // 替换当前的 Fragment 为 HomeFragment
                    transaction.replace(android.R.id.content, homeFragment);

                    // 提交事务
                    transaction.commit();
                }
            }
        });
        binding.exitIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);//正常退出
                System.exit(1);//非正常退出
            }
        });
    }
}
