package com.example.jetpack.components.DiffUtil;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.jetpack.components.Adapter.QuoteAdapter;
import com.example.jetpack.components.LiveData.MyViewModelFactory;
import com.example.jetpack.components.databinding.ActivityDiffUtilsBinding;
import com.example.jetpack.components.myModel.MainViewModel;
import com.example.jetpack.components.myModel.Quote;

import java.util.ArrayList;
import java.util.List;

public class DiffutilsActivity extends AppCompatActivity {

    ActivityDiffUtilsBinding binding;
    MainViewModel viewModel;
    QuoteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDiffUtilsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        viewModel = new ViewModelProvider(this, new MyViewModelFactory(this)).get(MainViewModel.class);

        binding.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.removeFirstItemFromQuoteData();
            }
        });

        setDataToAdapter();
    }

    private void setDataToAdapter() {
        binding.recyclerQuotes.setLayoutManager(new LinearLayoutManager(this));
        adapter = new QuoteAdapter(this, new ArrayList<>());
        binding.recyclerQuotes.setAdapter(adapter);

        viewModel.getQuoteData().observe(this, new Observer<List<Quote>>() {
            @Override
            public void onChanged(List<Quote> quotes) {
                adapter.updateData(quotes);
            }
        });
    }
}