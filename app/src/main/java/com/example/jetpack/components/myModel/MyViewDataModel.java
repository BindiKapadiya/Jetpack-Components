package com.example.jetpack.components.myModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Bindi : 15-07-2024
 */
public class MyViewDataModel extends ViewModel {

    public MutableLiveData<String> data = new MutableLiveData<>("This is sample");

    public void updateDataText() {
        data.setValue("New updated data... !!");
    }

}
