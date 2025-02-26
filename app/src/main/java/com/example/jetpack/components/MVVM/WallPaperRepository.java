package com.example.jetpack.components.MVVM;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.jetpack.components.Database.Entity.Quote;
import com.example.jetpack.components.Database.QuoteDao;
import com.example.jetpack.components.Database.QuoteDatabase;
import com.example.jetpack.components.Retrofit.APIClient;
import com.example.jetpack.components.Retrofit.APIInterface;
import com.example.jetpack.components.Utils.NetworkUtil;
import com.example.jetpack.components.myModel.WallPaperModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Bindi : 16-07-2024
 */
public class WallPaperRepository {

    private static final String TAG = WallPaperRepository.class.getSimpleName();
    QuoteDatabase database;
    QuoteDao dao;
    Context context;
    MutableLiveData<StateData<List<WallPaperModel>>> wallPaperList = new MutableLiveData<>();

    public WallPaperRepository(Context context) {
        database = QuoteDatabase.getDatabase(context);
        dao = database.quoteDao();
        this.context = context;
    }

    public void insertQuote(Quote quote) {
        QuoteDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.insertQuote(quote);
            }
        });
    }

    public LiveData<List<Quote>> getAllQuotes() {
        return dao.getAllQuotes();
    }

    public void getWallPapers(int page) {
        wallPaperList.postValue(StateData.loading());

        if (NetworkUtil.isNetworkAvailable(context)) {
            APIInterface apiInterface = APIClient.getClient("http://app1.remimobile.com/").create(APIInterface.class);
            apiInterface.getWallPaperList(0, 20).enqueue(new Callback<List<WallPaperModel>>() {
                @Override
                public void onResponse(@NonNull Call<List<WallPaperModel>> call, @NonNull Response<List<WallPaperModel>> response) {
                    if (response.body() != null) {
                        QuoteDatabase.databaseWriteExecutor.execute(new Runnable() {
                            @Override
                            public void run() {
                                dao.insertWallPapers(response.body());
                            }
                        });
                        wallPaperList.postValue(StateData.success(response.body()));
                    } else {
                        wallPaperList.postValue(StateData.error("API ERROR", null));
                    }
                }

                @Override
                public void onFailure(@NonNull Call<List<WallPaperModel>> call, @NonNull Throwable t) {
                    wallPaperList.postValue(StateData.error(t.getMessage(), null));
                }
            });
        } else {
            QuoteDatabase.databaseWriteExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    wallPaperList.postValue(StateData.success(dao.getWallPapers()));
                }
            });
        }
    }

    public MutableLiveData<StateData<List<WallPaperModel>>> getWallPaperList() {
        return wallPaperList;
    }

    public void getWallPaperBackground() {
        if (NetworkUtil.isNetworkAvailable(context)) {
            APIInterface apiInterface = APIClient.getClient("http://app1.remimobile.com/").create(APIInterface.class);
            apiInterface.getWallPaperList(0, 5).enqueue(new Callback<List<WallPaperModel>>() {
                @Override
                public void onResponse(@NonNull Call<List<WallPaperModel>> call, @NonNull Response<List<WallPaperModel>> response) {
                    if (response.body() != null) {
                        QuoteDatabase.databaseWriteExecutor.execute(new Runnable() {
                            @Override
                            public void run() {
                                dao.insertWallPapers(response.body());
                            }
                        });
                    } else {
                    }
                }

                @Override
                public void onFailure(@NonNull Call<List<WallPaperModel>> call, @NonNull Throwable t) {
                }
            });
        }
    }
}
