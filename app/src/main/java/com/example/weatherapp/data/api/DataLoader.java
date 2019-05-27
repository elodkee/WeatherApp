package com.example.weatherapp.data.api;

import com.example.weatherapp.App;
import com.example.weatherapp.constant.Constans;
import com.example.weatherapp.data.RetrofitClient;
import com.example.weatherapp.data.model.ForecastResult;



import javax.inject.Inject;

import io.reactivex.Observable;

public class DataLoader {

    @Inject
    RetrofitClient retrofitClient;

    public DataLoader() {
        App.app().getComponent().inject(this);
    }

    public Observable<ForecastResult> getForecast(double lat, double lon){
        String qParam = String.valueOf(lat)+ "," + String.valueOf(lon);
        return retrofitClient.getRetrofitInstance().getForecast(Constans.API_KEY, qParam, 8);
    }

    public Observable<ForecastResult> getCurrent(double lat, double lon){
        String qParam = String.valueOf(lat)+ "," + String.valueOf(lon);
        return retrofitClient.getRetrofitInstance().getCurrent(Constans.API_KEY, qParam);
    }

}
