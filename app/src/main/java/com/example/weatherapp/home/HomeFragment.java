package com.example.weatherapp.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weatherapp.App;
import com.example.weatherapp.R;
import com.example.weatherapp.base.BaseFragment;
import com.example.weatherapp.constant.Constans;
import com.example.weatherapp.navigation.AppNavigator;

import javax.inject.Inject;

public class HomeFragment extends BaseFragment<HomeView, HomePresenter> implements HomeView {

    public static final String TAG = HomeFragment.class.getSimpleName();

    @Inject
    AppNavigator mNavigator;

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.home_layout, container, false);
        App.app().getComponent().inject(this);
        mNavigator.showFragment(getFragmentManager(), Constans.FORECAST_FRAGMENT, getArguments());
        mNavigator.showFragment(getFragmentManager(), Constans.CONTENT_FRAGMENT, getArguments());
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected HomePresenter onCreatePresenter() {
        return new HomePresenter();
    }

    @Override
    protected HomeView getThisView() {
        return this;
    }
}
