package com.example.jetpack.components;

import android.app.Application;

import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import com.example.jetpack.components.MVVM.WallPaperRepository;
import com.example.jetpack.components.WorkManager.QuoteWorker;

import java.util.concurrent.TimeUnit;

/**
 * Created by Bindi : 18-07-2024
 */
public class MyApplication extends Application {

    public WallPaperRepository repository;

    @Override
    public void onCreate() {
        super.onCreate();

        initial();
        setUpWorker();
    }

    private void initial() {
        repository = new WallPaperRepository(this);
    }

    private void setUpWorker() {
        Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        PeriodicWorkRequest workRequest = new PeriodicWorkRequest.Builder(QuoteWorker.class, 1, TimeUnit.MINUTES).setConstraints(constraints).build();
        WorkManager.getInstance(this).enqueue(workRequest);
    }
}
