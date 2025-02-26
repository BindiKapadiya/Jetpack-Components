package com.example.jetpack.components.MVVM;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.jetpack.components.Adapter.QuoteRoomAdapter;
import com.example.jetpack.components.Adapter.WallPaperAdapter;
import com.example.jetpack.components.Database.Entity.Quote;
import com.example.jetpack.components.R;
import com.example.jetpack.components.databinding.ActivityMvvmDemoBinding;
import com.example.jetpack.components.myModel.WallPaperModel;

import java.util.ArrayList;
import java.util.List;

public class MvvmDemoActivity extends AppCompatActivity {

    private static final String TAG = MvvmDemoActivity.class.getSimpleName();
    ActivityMvvmDemoBinding binding;
    WallPaperViewModel viewModel;
    WallPaperRepository repository;
    int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_demo);

        repository = new WallPaperRepository(this);
        viewModel = new ViewModelProvider(this, new QuoteViewModelFactory(repository)).get(WallPaperViewModel.class);

        binding.btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                viewModel.insertQuote(new Quote(0, "This is testing " + counter, "Testing " + counter, 0));
                viewModel.insertQuote(new Quote(0, "This is testing " + counter, "Testing " + counter));
                counter++;
            }
        });

//        setQuotesDataToAdapter();
        setWallPapersDataToAdapter();
    }

    private void setQuotesDataToAdapter() {
        binding.btnAddNew.setVisibility(View.VISIBLE);

        QuoteRoomAdapter adapter = new QuoteRoomAdapter(this, new ArrayList<>());
        binding.recyclerQuote.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerQuote.setAdapter(adapter);

        viewModel.getAllQuotes().observe(this, new Observer<List<Quote>>() {
            @Override
            public void onChanged(List<Quote> quotes) {
                adapter.updateData(quotes);

            }
        });
    }

    private void setWallPapersDataToAdapter() {
        binding.btnAddNew.setVisibility(View.GONE);

        WallPaperAdapter adapter = new WallPaperAdapter(this, new ArrayList<>());
        binding.recyclerQuote.setLayoutManager(new GridLayoutManager(this, 3));
        binding.recyclerQuote.setAdapter(adapter);

        viewModel.getWallPapers().observe(this, new Observer<StateData<List<WallPaperModel>>>() {
            @Override
            public void onChanged(StateData<List<WallPaperModel>> stateData) {
                switch (stateData.status) {
                    case SUCCESS:
                        binding.progressBar.setVisibility(View.GONE);
                        assert stateData.data != null;
                        adapter.updateData(stateData.data);
                        break;

                    case LOADING:
                        binding.progressBar.setVisibility(View.VISIBLE);
                        break;

                    case ERROR:
                        binding.progressBar.setVisibility(View.GONE);
                        Toast.makeText(MvvmDemoActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }


}