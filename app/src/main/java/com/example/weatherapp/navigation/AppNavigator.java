package com.example.weatherapp.navigation;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;

import com.example.weatherapp.R;
import com.example.weatherapp.base.BaseFragment;
import com.example.weatherapp.constant.Constans;
import com.example.weatherapp.home.HomeFragment;
import com.example.weatherapp.home.forecast.ForecastFragment;
import com.example.weatherapp.home.viewpager.ContentFragment;
import com.example.weatherapp.newfragment.NewFragment;


public class AppNavigator extends Navigator {

    private Context mContext;

    public AppNavigator(Context context) {
        this.mContext = context;
    }

    @Override
    public void setNavigator(@Nullable Navigator navigator) {
    }

    @Override
    public boolean go(@NonNull int link, @NonNull Object... args) {
        switch (link) {
            default:
                return false;
        }
    }

    public void showFragment(FragmentManager fragmentManager, int requestId, Bundle args) {
        BaseFragment fragment;
        switch (requestId) {
            case Constans.HOME_FRAGMENT:
                fragment = HomeFragment.newInstance();
                fragment.setArguments(args);
                if (fragmentManager != null) {
                    fragmentManager.beginTransaction()
                            .replace(R.id.overlay_fragment, fragment, HomeFragment.TAG)
                            .commit();
                }
                break;
            case Constans.FORECAST_FRAGMENT:
                fragment = ForecastFragment.newInstance();
                fragment.setArguments(args);
                if (fragmentManager != null) {
                    fragmentManager.beginTransaction()
                            .replace(R.id.forecast_fragment, fragment, ForecastFragment.TAG)
                            .commit();
                }
                break;
            case Constans.CONTENT_FRAGMENT:
                fragment = ContentFragment.newInstance();
                fragment.setArguments(args);
                if (fragmentManager != null) {
                    fragmentManager.beginTransaction()
                            .replace(R.id.weather_day_contanier, fragment, ContentFragment.TAG)
                            .commit();
                }
                break;
            case Constans.NEW_FRAGMENT:
                fragment = NewFragment.newInstance();
                fragment.setArguments(args);
                if (fragmentManager != null) {
                    fragmentManager.beginTransaction()
                            .add(R.id.overlay_fragment, fragment, ContentFragment.TAG)
                            .addToBackStack("FRAGMENY")
                            .commit();
                }
                break;
            default:
                break;
        }

    }


}
