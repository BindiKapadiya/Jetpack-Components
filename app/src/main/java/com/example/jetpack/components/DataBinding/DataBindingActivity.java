package com.example.jetpack.components.DataBinding;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.jetpack.components.databinding.ActivityDataBindingBinding;
import com.example.jetpack.components.myModel.Quote;
import com.example.jetpack.components.myModel.MyViewDataModel;
import com.example.jetpack.components.R;

public class DataBindingActivity extends AppCompatActivity {

    ActivityDataBindingBinding binding;
    MyViewDataModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);

//        setFirstWay();
        setSecondWay();
//        setThirdWay();

    }

    // TODO DataBinding with ViewModel & LiveData
    private void setThirdWay() {
        viewModel = new ViewModelProvider(this).get(MyViewDataModel.class);

        binding.setMainViewModel(viewModel);  // bind to view model
        binding.setLifecycleOwner(this);  //  bind to live data
    }

    // TODO DataBinding with Model
    private void setSecondWay() {
        Quote quote = new Quote("Hello.. Good morning !!", "Bindi");
        binding.setModel(quote);
    }

    private void setFirstWay() {
        binding.tvText.setText("Hello.. Good morning !!");
        binding.tvAuthor.setText("Bindi Kapadiya");
    }

}