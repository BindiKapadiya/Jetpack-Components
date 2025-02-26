package com.example.jetpack.components.Retrofit;

import androidx.annotation.NonNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Bindi : 10-07-2024
 */
public class APIClient {

    private static Retrofit retrofit;

    public static Retrofit getClient(String url) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        OkHttpClient client = new OkHttpClient.Builder().
                connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS).addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit;
    }


    public static class NullOnEmptyConverterFactory extends Converter.Factory {
        @Override
        public Converter<ResponseBody, ?> responseBodyConverter(@NonNull Type type, @NonNull Annotation[] annotations, Retrofit retrofit) {
            final Converter<ResponseBody, ?> delegate = retrofit.nextResponseBodyConverter(this, type, annotations);
            return (Converter<ResponseBody, Object>) body -> {
                if (body.contentLength() == 0) return null;
                return delegate.convert(body);
            };
        }
    }

}
