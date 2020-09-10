package com.example.gadsleaderboard.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientInstance {
    private static OkHttpClient getHttpClient(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(30, TimeUnit.SECONDS);
        httpClient.readTimeout(30, TimeUnit.SECONDS);
        httpClient.writeTimeout(30, TimeUnit.SECONDS);
        httpClient.addInterceptor(logging);
        return httpClient.build();
    }

    public static Retrofit getClientInstance(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
