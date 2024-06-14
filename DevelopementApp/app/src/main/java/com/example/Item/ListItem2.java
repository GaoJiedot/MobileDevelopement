package com.example.Item;

import android.net.Uri;

public class ListItem2 {


    private int imageReId;
    private String name;
    private String description;

    public int getImageReId() {
        return imageReId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ListItem2(int imageReId, String name, String description) {
        this.imageReId = imageReId;
        this.name = name;
        this.description = description;
    }
}
