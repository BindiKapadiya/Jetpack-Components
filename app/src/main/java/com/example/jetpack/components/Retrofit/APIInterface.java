package com.example.jetpack.components.Retrofit;

import com.example.jetpack.components.myModel.WallPaperModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Bindi : 10-07-2024
 */
public interface APIInterface {

    @GET("api/wallpapers/new/")
    Call<List<WallPaperModel>> getWallPaperList(@Query("skip") int skip, @Query("limit") int limit);

}
