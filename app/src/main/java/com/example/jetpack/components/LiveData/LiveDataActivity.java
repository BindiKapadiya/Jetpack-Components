package com.example.jetpack.components.LiveData;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.jetpack.components.databinding.ActivityLiveDataBinding;
import com.example.jetpack.components.myModel.Quote;
import com.example.jetpack.components.R;
import com.example.jetpack.components.myModel.MainViewModel;

public class LiveDataActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityLiveDataBinding binding;
    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLiveDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this, new MyViewModelFactory(this)).get(MainViewModel.class);

        binding.btnPrevious.setOnClickListener(this);
        binding.btnNext.setOnClickListener(this);
        binding.btnUpdate.setOnClickListener(this);

        viewModel.getQuote().observe(this, new Observer<Quote>() {
            @Override
            public void onChanged(Quote quote) {
                setQuote(quote);
            }
        });
    }

    private void setQuote(Quote quote) {
        binding.tvText.setText(quote.getText());
        binding.tvAuthor.setText(quote.getAuthor());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnNext:
                viewModel.getNext();
                break;

            case R.id.btnPrevious:
                viewModel.getPrevious();
                break;

            case R.id.btnUpdate:
                viewModel.updateQuote();
                break;

        }
    }
}