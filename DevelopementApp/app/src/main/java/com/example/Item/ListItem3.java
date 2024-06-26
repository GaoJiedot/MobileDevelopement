package com.example.Item;

import android.os.Parcel;
import android.os.Parcelable;

public class ListItem3 implements Parcelable {
    private int imageAvatar;
    private String name;
    private String title;
    private int imageShare; // 改为 String 类型来存储图片路径

    public ListItem3(int imageAvatar, String name, String title, int imageShare) {
        this.imageAvatar = imageAvatar;
        this.name = name;
        this.title = title;
        this.imageShare = imageShare;
    }

    protected ListItem3(Parcel in) {
        imageAvatar = in.readInt();
        name = in.readString();
        title = in.readString();
        imageShare = in.readInt();
    }

    public static final Creator<ListItem3> CREATOR = new Creator<ListItem3>() {
        @Override
        public ListItem3 createFromParcel(Parcel in) {
            return new ListItem3(in);
        }

        @Override
        public ListItem3[] newArray(int size) {
            return new ListItem3[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageAvatar);
        dest.writeString(name);
        dest.writeString(title);
        dest.writeInt(imageShare);
    }
}