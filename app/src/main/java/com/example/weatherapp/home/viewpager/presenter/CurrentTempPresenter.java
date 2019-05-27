package com.example.weatherapp.home.viewpager.presenter;

import android.util.Log;

import com.example.weatherapp.App;
import com.example.weatherapp.base.BasePresenter;
import com.example.weatherapp.data.api.DataLoader;
import com.example.weatherapp.data.model.ForecastResult;
import com.example.weatherapp.home.forecast.ForecastPresenter;
import com.example.weatherapp.home.viewpager.view.CurrentTempView;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CurrentTempPresenter extends BasePresenter<CurrentTempView> {

    @Inject
    DataLoader dataLoader;

    public CurrentTempPresenter() {
        App.app().getComponent().inject(this);
    }

    public void loadData(double latitude, double longitude) {
        dataLoader.getCurrent(latitude, longitude)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CurrentObserver());

    }

    private class CurrentObserver implements Observer<ForecastResult> {

        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(ForecastResult forecastResult) {
            mView.onLoadCurrent(forecastResult);
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
