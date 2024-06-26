package com.example.Item;

import android.graphics.Bitmap;

public class ListItem3 {
    private int imageAvatar;
    private String name;
    private String title;
    private int imageShare;

    public ListItem3(int imageAvatar, String name, String title, int imageShare) {
        this.imageAvatar = imageAvatar;
        this.name = name;
        this.title = title;
        this.imageShare = imageShare;
    }

    public int getImageAvatar() {
        return imageAvatar;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public int getImageShare() {
        return imageShare;
    }


}