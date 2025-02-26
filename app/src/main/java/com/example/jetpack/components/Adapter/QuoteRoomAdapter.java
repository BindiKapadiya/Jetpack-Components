package com.example.jetpack.components.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jetpack.components.Database.Entity.Quote;
import com.example.jetpack.components.databinding.ItemQuoteBinding;

import java.util.List;

public class QuoteRoomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Quote> dataList;

    public QuoteRoomAdapter(Context context, List<Quote> list) {
        this.context = context;
        this.dataList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(ItemQuoteBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.binding.txtId.setText("" + dataList.get(position).getId());
        viewHolder.binding.txtText.setText(dataList.get(position).getText());
        viewHolder.binding.txtAuthor.setText(dataList.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void updateData(List<Quote> list) {
        dataList.clear();
        dataList.addAll(list);
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ItemQuoteBinding binding;

        public MyViewHolder(@NonNull ItemQuoteBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
