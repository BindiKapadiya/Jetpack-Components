package com.example.jetpack.components.WorkManager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.jetpack.components.MyApplication;

/**
 * Created by Bindi : 18-07-2024
 */
public class QuoteWorker extends Worker {

    private static final String TAG = QuoteWorker.class.getSimpleName();
    Context context;

    public QuoteWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.e(TAG, "doWork: ");
        ((MyApplication) context).repository.getWallPaperBackground();
        return Result.success();
    }
}
