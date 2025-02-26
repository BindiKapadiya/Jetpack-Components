package com.example.jetpack.components.myModel;

import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.jetpack.components.Retrofit.APIClient;
import com.example.jetpack.components.Retrofit.APIInterface;

/**
 * Created by Bindi : 10-07-2024
 */
public class MyViewModel extends ViewModel {

    private static final String TAG = MyViewModel.class.getSimpleName();
    private final MutableLiveData<String> text;
    APIInterface apiInterface;

    public MyViewModel() {
        text = new MutableLiveData<>();
        text.setValue("Hello World !!...........");

        apiInterface = APIClient.getClient("http://app1.remimobile.com/").create(APIInterface.class);
    }


    public void setText(String newText) {
        text.setValue(newText);
    }

    public LiveData<String> getText() {
        return text;
    }

    public void fetchNewData() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                text.postValue("New Text from Background Operation");
            }
        }, 5000);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

}
