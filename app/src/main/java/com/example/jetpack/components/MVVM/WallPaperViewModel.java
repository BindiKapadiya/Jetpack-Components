package com.example.jetpack.components.MVVM;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.jetpack.components.Database.Entity.Quote;
import com.example.jetpack.components.myModel.WallPaperModel;

import java.util.List;

/**
 * Created by Bindi : 16-07-2024
 */
public class WallPaperViewModel extends ViewModel {

    WallPaperRepository repository;

    public WallPaperViewModel(WallPaperRepository repository) {
        this.repository = repository;

        repository.getWallPapers(1);
    }

    public LiveData<List<Quote>> getAllQuotes() {
        return repository.getAllQuotes();
    }


    public LiveData<StateData<List<WallPaperModel>>> getWallPapers() {
        return repository.getWallPaperList();
    }

    public void insertQuote(Quote quote) {
        repository.insertQuote(quote);
    }

}
