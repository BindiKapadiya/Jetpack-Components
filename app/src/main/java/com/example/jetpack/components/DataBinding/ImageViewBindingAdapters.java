package com.example.jetpack.components.DataBinding;

import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;

import com.bumptech.glide.Glide;

/**
 * Created by Bindi : 15-07-2024
 */

@BindingMethods({
        @BindingMethod(type = android.widget.ImageView.class, attribute = "android:tint", method = "setImageTintList"),
        @BindingMethod(type = android.widget.ImageView.class, attribute = "android:tintMode", method = "setImageTintMode"),
        @BindingMethod(type = android.widget.ImageView.class, attribute = "imageFromUrl", method = "imageFromUrl"),
})
public class ImageViewBindingAdapters {

    private static final String TAG = ImageViewBindingAdapters.class.getSimpleName();

    @BindingAdapter("android:src")
    public static void setImageUri(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    @BindingAdapter("imageFromUrl")
    public static void imageFromUrl(ImageView imageView, String url) {
        Log.e(TAG, "imageFromUrl: " + url);
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

}
