package com.example.jetpack.components;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jetpack.components.DataBinding.DataBindingActivity;
import com.example.jetpack.components.DiffUtil.DiffutilsActivity;
import com.example.jetpack.components.LiveData.LiveDataActivity;
import com.example.jetpack.components.MVVM.MvvmDemoActivity;
import com.example.jetpack.components.ViewModel.ViewModelActivity;
import com.example.jetpack.components.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLiveData.setOnClickListener(this);
        binding.btnViewModel.setOnClickListener(this);
        binding.btnDataBinding.setOnClickListener(this);
        binding.btnMVVM.setOnClickListener(this);
        binding.btnDiffUtils.setOnClickListener(this);
        binding.btnWorkManager.setOnClickListener(this);

        binding.btnLiveData.setText("Home 1");
        binding.btnViewModel.setText("Home 2");
        binding.btnDataBinding.setText("Home 3");
        binding.btnMVVM.setText("Home 4");
        binding.btnDiffUtils.setText("Home 5");
        binding.btnWorkManager.setText("Home 6");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnViewModel:
                startActivity(new Intent(this, ViewModelActivity.class));
                break;

            case R.id.btnDataBinding:
                startActivity(new Intent(this, DataBindingActivity.class));
                break;

            case R.id.btnMVVM:
                startActivity(new Intent(this, MvvmDemoActivity.class));
                break;

            case R.id.btnDiffUtils:
                startActivity(new Intent(this, DiffutilsActivity.class));
                break;

            case R.id.btnLiveData:
                startActivity(new Intent(this, LiveDataActivity.class));
                break;
        }
    }
}