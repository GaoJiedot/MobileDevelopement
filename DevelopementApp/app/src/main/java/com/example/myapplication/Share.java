package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.Item.ListItem3;

public class Share extends AppCompatActivity {
    private TextView cancelTextView;
    private Button publishButton;
    private ImageView addImageView;
    private EditText titleEditText;
    private int selectedImageResource = R.drawable.nemo_background; // 默认图片资源ID

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share);

        cancelTextView = findViewById(R.id.share_cancel);
        publishButton = findViewById(R.id.share_button);
        addImageView = findViewById(R.id.share_add);
        titleEditText = findViewById(R.id.share_title);

        cancelTextView.setOnClickListener(v -> finish());

        publishButton.setOnClickListener(v -> publishPost());

        addImageView.setOnClickListener(v -> selectImage());
    }

    private void selectImage() {
        // 这里应该打开一个对话框让用户选择预定义的图片资源
        // 为了简化，我们这里只是在几个预定义的图片之间循环
        int[] imageResources = {R.drawable.nemo_background, R.drawable.nemo_background, R.drawable.nemo_background};
        int currentIndex = 0;
        for (int i = 0; i < imageResources.length; i++) {
            if (imageResources[i] == selectedImageResource) {
                currentIndex = (i + 1) % imageResources.length;
                break;
            }
        }
        selectedImageResource = imageResources[currentIndex];
        addImageView.setImageResource(selectedImageResource);
    }

    private void publishPost() {
        String title = titleEditText.getText().toString().trim();
        if (title.isEmpty()) {
            Toast.makeText(this, "请输入标题", Toast.LENGTH_SHORT).show();
            return;
        }

        // 创建一个新的 ListItem3 对象
        ListItem3 newPost = new ListItem3(
                R.drawable.nemo_background, // 使用默认头像
                "用户名", // 这里可以使用实际的用户名
                title,
                selectedImageResource
        );

        // 创建一个 Intent 并将新帖子数据放入其中
        Intent resultIntent = new Intent();
        resultIntent.putExtra("newPost", newPost);

        // 设置结果并结束 Activity
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}