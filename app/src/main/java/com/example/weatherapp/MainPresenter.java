package com.example.weatherapp;

import com.example.weatherapp.base.BasePresenter;
import com.example.weatherapp.data.api.DataLoader;

import javax.inject.Inject;


public class MainPresenter extends BasePresenter<MainView> {

    @Inject
    DataLoader dataLoader;

    public MainPresenter() {
        App.app().getComponent().inject(this);
    }

}
