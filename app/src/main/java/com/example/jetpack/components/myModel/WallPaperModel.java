package com.example.jetpack.components.myModel;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bindi : 10-07-2024
 */

@Entity(tableName = "wallpaper")
public class WallPaperModel {

    @PrimaryKey(autoGenerate = true)
    private int wallPaperId;

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("img_large")
    @Expose
    private String imgLarge;
    @SerializedName("favorite")
    @Expose
    private Integer favorite;
    @SerializedName("live")
    @Expose
    private Integer live;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("category_id")
    @Expose
    private Integer categoryId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("img_thumb")
    @Expose
    private String imgThumb;
    @SerializedName("download")
    @Expose
    private Integer download;
    @SerializedName("premium")
    @Expose
    private Integer premium;
    @SerializedName("date_upload")
    @Expose
    private String dateUpload;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public int getWallPaperId() {
        return wallPaperId;
    }

    public void setWallPaperId(int wallPaperId) {
        this.wallPaperId = wallPaperId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgLarge() {
        return imgLarge;
    }

    public void setImgLarge(String imgLarge) {
        this.imgLarge = imgLarge;
    }

    public Integer getFavorite() {
        return favorite;
    }

    public void setFavorite(Integer favorite) {
        this.favorite = favorite;
    }

    public Integer getLive() {
        return live;
    }

    public void setLive(Integer live) {
        this.live = live;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgThumb() {
        return imgThumb;
    }

    public void setImgThumb(String imgThumb) {
        this.imgThumb = imgThumb;
    }

    public Integer getDownload() {
        return download;
    }

    public void setDownload(Integer download) {
        this.download = download;
    }

    public Integer getPremium() {
        return premium;
    }

    public void setPremium(Integer premium) {
        this.premium = premium;
    }

    public String getDateUpload() {
        return dateUpload;
    }

    public void setDateUpload(String dateUpload) {
        this.dateUpload = dateUpload;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
