package com.javasilev.testtask.network;

import android.support.annotation.NonNull;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Aleksei Vasilev.
 */

@SuppressWarnings("SpellCheckingInspection")
public class TypicodeService {
    private static TypicodeService sInstance;

    private final Retrofit mRetrofit;

    public static TypicodeService getInstance() {
        if (sInstance == null) {
            synchronized (TypicodeService.class) {
                if (sInstance == null) {
                    sInstance = new TypicodeService();
                }
            }
        }

        return sInstance;
    }

    private TypicodeService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(TypicodeApiUrls.getApiBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(createOkHttpClient())
                .build();
    }

    @NonNull
    private OkHttpClient createOkHttpClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    public TypicodeClient createTypicodeClient() {
        return mRetrofit.create(TypicodeClient.class);
    }
}
