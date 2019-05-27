package com.example.weatherapp.home.forecast;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.weatherapp.R;
import com.example.weatherapp.base.BaseFragment;
import com.example.weatherapp.constant.Constans;
import com.example.weatherapp.data.model.ForecastResult;
import com.example.weatherapp.data.model.Forecastday;
import com.example.weatherapp.home.forecast.list.ForecastRecyclerViewAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForecastFragment extends BaseFragment<ForecastView, ForecastPresenter> implements ForecastView {

    public static final String TAG = ForecastFragment.class.getSimpleName();
    private double latitude;
    private double longitude;

    @BindView(R.id.forecast_recycler_view)
    RecyclerView recyclerView;
    ForecastRecyclerViewAdapter mAdapter;
    ArrayList<Forecastday> mForecastList = new ArrayList<>();

    public static ForecastFragment newInstance() {

        Bundle args = new Bundle();
        ForecastFragment fragment = new ForecastFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.forecast_fragment_layout, container, false);
        ButterKnife.bind(this,view);
        if (getArguments() != null) {
            latitude = getArguments().getDouble(Constans.LATITUDE);
            longitude = getArguments().getDouble(Constans.LONGITUDE);
        }
        initUi();
        mPresenter.loadData(latitude, longitude);
        return view;
    }

    @Override
    protected ForecastPresenter onCreatePresenter() {
        return new ForecastPresenter();
    }

    @Override
    protected ForecastView getThisView() {
        return this;
    }

    @Override
    public void onLoadForecast(ForecastResult forecastResult) {
        mAdapter.updateList(forecastResult.getForecast().getForecastdays());
    }

    private void initUi() {
        if (getActivity() != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayout.HORIZONTAL, false));
            mAdapter = new ForecastRecyclerViewAdapter(getActivity(), mForecastList);
            recyclerView.setAdapter(mAdapter);
        }
    }
}
