package com.example.jetpack.components.LiveData;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.jetpack.components.myModel.MainViewModel;

/**
 * Created by Bindi : 13-07-2024
 */
public class MyViewModelFactory implements ViewModelProvider.Factory {

    Context context;

    public MyViewModelFactory(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainViewModel(context);
    }
}
