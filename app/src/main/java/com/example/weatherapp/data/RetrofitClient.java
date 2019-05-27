package com.example.weatherapp.data;

import com.example.weatherapp.constant.Constans;

import okhttp3.OkHttpClient;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private Endpoint retrofit;

    public Endpoint getRetrofitInstance() {
        if (retrofit == null) {
            OkHttpClient.Builder http = new OkHttpClient.Builder();

            OkHttpClient mHttpClient = http
                    .build();

            retrofit = new retrofit2.Retrofit.Builder()
                    .client(mHttpClient)
                    .baseUrl(Constans.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build().create(Endpoint.class);
        }
        return retrofit;
    }
}
