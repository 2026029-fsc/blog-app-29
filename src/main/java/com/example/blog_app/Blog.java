package com.example.blog_app;

public class Blog {
    private long id;
    private String title;
    private String text;

    public Blog(long id, String title, String text) {
        this.id = id;
        this.text = text;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Blog() {
    }
}