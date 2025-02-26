package com.example.jetpack.components.Adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.jetpack.components.databinding.ItemWallpaperBinding;
import com.example.jetpack.components.myModel.WallPaperModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bindi : 10-07-2024
 */
public class WallPaperAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = WallPaperAdapter.class.getSimpleName();
    private List<WallPaperModel> dataList = new ArrayList<>();
    Activity activity;

    public WallPaperAdapter(Activity activity, List<WallPaperModel> dataList) {
        this.activity = activity;
        this.dataList = dataList;
    }

    public void updateData(List<WallPaperModel> list) {
        Log.e(TAG, "updateData: " + list.size());
        dataList.clear();
        dataList.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(ItemWallpaperBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        Log.e(TAG, "onBindViewHolder: " + dataList.get(position).getImgThumb());
        Glide.with(activity.getApplicationContext()).load(dataList.get(position).getImgThumb()).diskCacheStrategy(DiskCacheStrategy.NONE).into(viewHolder.binding.imgThumb);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ItemWallpaperBinding binding;

        public MyViewHolder(@NonNull ItemWallpaperBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
