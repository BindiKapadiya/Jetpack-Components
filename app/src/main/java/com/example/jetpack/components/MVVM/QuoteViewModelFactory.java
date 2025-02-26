package com.example.jetpack.components.MVVM;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created by Bindi : 16-07-2024
 */
public class QuoteViewModelFactory implements ViewModelProvider.Factory {

    WallPaperRepository repository;

    public QuoteViewModelFactory(WallPaperRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new WallPaperViewModel(repository);
    }
}
