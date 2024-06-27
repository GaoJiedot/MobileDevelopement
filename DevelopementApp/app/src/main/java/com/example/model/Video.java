package com.example.model;

import java.util.List;

public class Video {
    private String title;
    private String share_url;
    private String author;
    private String item_cover;
    private long hot_value;
    private String hot_words;
    private long play_count;
    private long digg_count;
    private long comment_count;

    public Video(String title, String share_url, String author, String item_cover, long hot_value, String hot_words, long play_count, long digg_count, long comment_count) {
        this.title = title;
        this.share_url = share_url;
        this.author = author;
        this.item_cover = item_cover;
        this.hot_value = hot_value;
        this.hot_words = hot_words;
        this.play_count = play_count;
        this.digg_count = digg_count;
        this.comment_count = comment_count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getItem_cover() {
        return item_cover;
    }

    public void setItem_cover(String item_cover) {
        this.item_cover = item_cover;
    }

    public long getHot_value() {
        return hot_value;
    }

    public void setHot_value(long hot_value) {
        this.hot_value = hot_value;
    }

    public String getHot_words() {
        return hot_words;
    }

    public void setHot_words(String hot_words) {
        this.hot_words = hot_words;
    }

    public long getPlay_count() {
        return play_count;
    }

    public void setPlay_count(long play_count) {
        this.play_count = play_count;
    }

    public long getDigg_count() {
        return digg_count;
    }

    public void setDigg_count(long digg_count) {
        this.digg_count = digg_count;
    }

    public long getComment_count() {
        return comment_count;
    }

    public void setComment_count(long comment_count) {
        this.comment_count = comment_count;
    }
}

