package com.example.weatherapp.home.forecast;

import android.util.Log;

import com.example.weatherapp.App;
import com.example.weatherapp.base.BasePresenter;
import com.example.weatherapp.data.api.DataLoader;
import com.example.weatherapp.data.model.ForecastResult;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ForecastPresenter extends BasePresenter<ForecastView> {

    @Inject
    DataLoader dataLoader;

    public ForecastPresenter() {
        App.app().getComponent().inject(this);
    }

    public void loadData(double latitude, double longitude) {
        dataLoader.getForecast(latitude, longitude)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ForcastObserver());

    }

    private class ForcastObserver implements Observer<ForecastResult> {

        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(ForecastResult forecastResult) {
              mView.onLoadForecast(forecastResult);
        }

        @Override
        public void onError(Throwable e) {
            Log.d("LAZAR", e.getMessage());
        }

        @Override
        public void onComplete() {

        }
    }
}
