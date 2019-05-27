package com.example.weatherapp.dagger.modul;


import android.content.Context;

import com.example.weatherapp.data.RetrofitClient;
import com.example.weatherapp.data.api.DataLoader;
import com.example.weatherapp.navigation.AppNavigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModul {


    private Context mContext;

    public AppModul(Context context) {
        mContext = context;
    }

    @Provides
    @Singleton
    AppNavigator providerNavigatorRepository() {
        return new AppNavigator(mContext);
    }

    @Provides
    @Singleton
    RetrofitClient providerRetrofitClient() {
        return new RetrofitClient();
    }

    @Provides
    @Singleton
    DataLoader providerDataLoader(){
        return new DataLoader();
    }
}
