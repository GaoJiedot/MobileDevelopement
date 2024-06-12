package com.example.Item;

import android.widget.ImageView;

public class ListItem {
    private int imageResId;
    private String name;
    private String description;
    private String kind;


    public ListItem(int imageResId, String name, String description, String kind) {
        this.imageResId = imageResId;
        this.name = name;
        this.description = description;
        this.kind = kind;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getKind() {
        return kind;
    }
}