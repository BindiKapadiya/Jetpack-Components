package com.example.jetpack.components.myModel;

/**
 * Created by Bindi : 13-07-2024
 */

public class Quote {
    public String text;
    public String author;
    public String imgUrl = "https://play-lh.googleusercontent.com/DUv2Ka0xPglH03KuLWcxRlqJdKFKrUj1Cb0sYEG3lQHD1v8QmiUxo6uXzDoEs9ydjRQA";

    public Quote(String text, String author) {
        this.text = text;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
