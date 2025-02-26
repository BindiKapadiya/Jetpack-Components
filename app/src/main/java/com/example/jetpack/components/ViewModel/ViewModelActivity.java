package com.example.jetpack.components.ViewModel;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.jetpack.components.databinding.ActivityViewModelBinding;
import com.example.jetpack.components.myModel.MyViewModel;

public class ViewModelActivity extends AppCompatActivity {

    private static final String TAG = ViewModelActivity.class.getSimpleName();
    ActivityViewModelBinding binding;
    MyViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewModelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        initData();
    }

    private void initData() {
        myViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.tvText.setText(s);
            }
        });

        binding.etAddText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                myViewModel.setText(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        myViewModel.fetchNewData();

    }

}