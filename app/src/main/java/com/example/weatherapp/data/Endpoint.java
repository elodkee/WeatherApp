package com.example.weatherapp.data;

import com.example.weatherapp.data.model.ForecastResult;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Endpoint {

    @GET("forecast.json?")
    Observable<ForecastResult> getForecast(@Query("key") String key, @Query("q") String qParam, @Query("days") int days);

    @GET("current.json?")
    Observable<ForecastResult> getCurrent(@Query("key") String key, @Query("q") String qParam);
}
