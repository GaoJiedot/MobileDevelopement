package com.example.Activity;

import static androidx.core.app.PendingIntentCompat.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
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

public class Login extends AppCompatActivity {

    private Button login_btn;
    private EditText login_Et;
    private CheckBox login_cb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        login_Et = findViewById(R.id.login_et);
        login_btn = findViewById(R.id.login_button);
        login_cb = findViewById(R.id.login_cb);


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phonenumber = login_Et.getText().toString();
                boolean agreement = login_cb.isChecked();

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
    }
}
