package com.example.jetpack.components.myModel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bindi : 13-07-2024
 */
public class MainViewModel extends ViewModel {

    MutableLiveData<List<Quote>> quoteData = new MutableLiveData<>();
    public MutableLiveData<Quote> quote = new MutableLiveData<>();
    int index = 0;
    private Context context;

    public MainViewModel(Context context) {
        this.context = context;
    }

    public void updateQuote() {
        quote.setValue(new Quote("Hello !! Good morning...", "Bindi"));
    }

    public void removeFirstItemFromQuoteData() {
        List<Quote> currentList = quoteData.getValue();
        if (currentList != null && !currentList.isEmpty()) {
            currentList.remove(0);  // Remove the first item
            currentList.remove(5);
            quoteData.setValue(currentList);  // Set the modified list back to quoteData
        }
    }

    public void getPrevious() {
        index--;
        if (index == -1) {
            index = 0;
        }
        setCurrentQuoteData();
    }

    public MutableLiveData<List<Quote>> getQuoteData() {
        if (quoteData.getValue() == null || quoteData.getValue().isEmpty()) {
            getQuoteDataFromAssets();
        }
        return quoteData;
    }

    public void setQuote(MutableLiveData<Quote> quote) {
        this.quote = quote;
    }

    public MutableLiveData<Quote> getQuote() {
        if (quoteData.getValue() == null || quoteData.getValue().isEmpty()) {
            getQuoteDataFromAssets();
        }
        return quote;
    }

    public void getNext() {
        if (quoteData.getValue() != null || !quoteData.getValue().isEmpty()) {
            index++;
            if (index >= quoteData.getValue().size()) {
                index = quoteData.getValue().size();
            }
            setCurrentQuoteData();
        }
    }

    public void setCurrentQuoteData() {
        if (quoteData.getValue() != null || !quoteData.getValue().isEmpty()) {
            quote.setValue(quoteData.getValue().get(index));
        }
    }

    public void getQuoteDataFromAssets() {
        List<Quote> data = new ArrayList<>();
        String json = null;
        try {
            InputStream is = context.getAssets().open("quotes.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (json != null) {
            data = new Gson().fromJson(json, new TypeToken<List<Quote>>() {
            }.getType());
        }
        quoteData.setValue(data);

        setCurrentQuoteData();
    }

}
