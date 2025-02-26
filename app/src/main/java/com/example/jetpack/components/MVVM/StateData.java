package com.example.jetpack.components.MVVM;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by Bindi : 18-07-2024
 */
public class StateData<T> {

    public enum Status {SUCCESS, ERROR, LOADING}

    @NonNull
    public final Status status;
    @Nullable
    public final T data;
    @Nullable
    public final String message;

    private StateData(@NonNull Status status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> StateData<T> success(@NonNull T data) {
        return new StateData<>(Status.SUCCESS, data, null);
    }

    public static <T> StateData<T> error(String msg, @Nullable T data) {
        return new StateData<>(Status.ERROR, data, msg);
    }

    public static <T> StateData<T> loading() {
        return new StateData<>(Status.LOADING, null, null);
    }

}
