package com.example.weatherapp.dagger;


import com.example.weatherapp.App;
import com.example.weatherapp.MainPresenter;
import com.example.weatherapp.dagger.modul.AppModul;
import com.example.weatherapp.MainActivity;
import com.example.weatherapp.data.api.DataLoader;
import com.example.weatherapp.home.HomeFragment;
import com.example.weatherapp.home.forecast.ForecastPresenter;
import com.example.weatherapp.home.viewpager.presenter.CurrentTempPresenter;

import javax.inject.Singleton;

@Singleton
@dagger.Component(modules = {AppModul.class})

public interface Component {

    void inject(App app);
    void inject(MainActivity mainActivity);
    void inject(DataLoader dataLoader);

    void inject(MainPresenter mainPresenter);

    void inject(ForecastPresenter forecastPresenter);

    void inject(HomeFragment homeFragment);

    void inject(CurrentTempPresenter currentTempPresenter);
}
