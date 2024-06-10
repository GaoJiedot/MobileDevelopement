package com.example.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

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

        // 设置输入过滤器
        InputFilter digitFilter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                for (int i = start; i < end; i++) {
                    if (!Character.isDigit(source.charAt(i))) {
                        return "";
                    }
                }
                return null;
            }
        };
        login_Et.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11), digitFilter});

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
                    Intent intent = new Intent(Login.this, Home.class);
                    startActivity(intent);
                }
            }
        });
    }
}
