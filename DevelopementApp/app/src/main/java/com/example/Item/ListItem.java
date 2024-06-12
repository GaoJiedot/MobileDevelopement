package com.example.Item;

import android.widget.ImageView;

public class ListItem {
    private int imageResId;
    private String name;
    private String description;

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ListItem(int imageResId, String name, String description) {
        this.imageResId = imageResId;
        this.name = name;
        this.description = description;

    }
}