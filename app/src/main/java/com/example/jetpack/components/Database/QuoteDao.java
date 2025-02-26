package com.example.jetpack.components.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.jetpack.components.Database.Entity.Quote;
import com.example.jetpack.components.myModel.WallPaperModel;

import java.util.List;

/**
 * Created by Bindi : 16-07-2024
 */

@Dao
public interface QuoteDao {

    @Insert
    void insertQuote(Quote quote);

    @Query("SELECT * FROM quote")
    LiveData<List<Quote>> getAllQuotes();

    @Query("SELECT * FROM wallpaper")
    List<WallPaperModel> getWallPapers();

    @Insert
    void insertWallPapers(List<WallPaperModel> wallPaperList);

}
