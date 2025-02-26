package com.example.jetpack.components.Database.Entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by Bindi : 16-07-2024
 */


@Entity(tableName = "quote")
public class Quote {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String text;

    @NonNull
    private String author;

//    @NonNull
//    private int isActive;

    public Quote(int id, @NonNull String text, @NonNull String author/*, @NonNull int isActive*/) {
        this.id = id;
        this.text = text;
        this.author = author;
//        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getText() {
        return text;
    }

    public void setText(@NonNull String text) {
        this.text = text;
    }

    @NonNull
    public String getAuthor() {
        return author;
    }

    public void setAuthor(@NonNull String author) {
        this.author = author;
    }

//    public int getIsActive() {
//        return isActive;
//    }
//
//    public void setIsActive(int isActive) {
//        this.isActive = isActive;
//    }

}