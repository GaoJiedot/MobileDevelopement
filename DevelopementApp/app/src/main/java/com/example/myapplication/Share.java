package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Share extends AppCompatActivity {
    private static final int REQUEST_PERMISSIONS = 1;
    private static final int REQUEST_IMAGE_PICK = 2;

    private TextView textView;
    private Button button;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share);

        textView = findViewById(R.id.share_cancel);
        textView.setOnClickListener(v -> finish());

        button = findViewById(R.id.share_button);
        button.setOnClickListener(v -> {
            // Handle button click
        });

        imageView = findViewById(R.id.share_add);
        imageView.setOnClickListener(v -> {
            if (ContextCompat.checkSelfPermission(Share.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                // Request permissions
                ActivityCompat.requestPermissions(Share.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_PERMISSIONS);
            } else {
                // Open gallery to pick image
                openGallery();
            }
        });
    }

    private void openGallery() {
        Intent pickPhotoIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhotoIntent, REQUEST_IMAGE_PICK);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSIONS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openGallery();
            } else {
                // Permission denied
                // Handle the case where the user denied the permissions
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_PICK && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            if (selectedImageUri != null) {
                try {
                    Bitmap imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
                    imageView.setImageBitmap(imageBitmap);
                    // TODO: You can also add the selected image to your ListItem4 list here if needed
                    // itemList.add(new ListItem4(selectedImageUri));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
