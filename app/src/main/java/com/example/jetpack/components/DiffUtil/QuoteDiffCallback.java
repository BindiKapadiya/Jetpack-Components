package com.example.jetpack.components.DiffUtil;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.example.jetpack.components.myModel.Quote;

import java.util.List;
import java.util.Objects;

/**
 * Created by Bindi : 17-07-2024
 */
public class QuoteDiffCallback extends DiffUtil.Callback {

    private final List<Quote> oldList;
    private final List<Quote> newList;

    public QuoteDiffCallback(List<Quote> oldList, List<Quote> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return Objects.equals(oldList.get(oldItemPosition).text, newList.get(newItemPosition).text);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        boolean isPositionSame = oldItemPosition == newItemPosition;
        boolean isContentSame = oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
        return isPositionSame && isContentSame;
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
