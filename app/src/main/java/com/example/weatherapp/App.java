package com.example.weatherapp;


import android.app.Application;

import com.example.weatherapp.dagger.Component;
import com.example.weatherapp.dagger.DaggerComponent;
import com.example.weatherapp.dagger.modul.AppModul;

public class App extends Application {

    private Component mComponent;
    private static App mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        mComponent = DaggerComponent.builder()
                .appModul(new AppModul(this))
                .build();
        mComponent.inject(this);
    }

    public static App app() {
        return mApp;
    }
    public Component getComponent() {
        return this.mComponent;
    }


}
