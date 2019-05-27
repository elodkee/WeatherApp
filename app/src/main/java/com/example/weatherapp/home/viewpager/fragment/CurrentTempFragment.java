package com.example.weatherapp.home.viewpager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.weatherapp.R;
import com.example.weatherapp.base.BaseFragment;
import com.example.weatherapp.constant.Constans;
import com.example.weatherapp.data.model.ForecastResult;
import com.example.weatherapp.home.viewpager.presenter.CurrentTempPresenter;
import com.example.weatherapp.home.viewpager.view.CurrentTempView;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CurrentTempFragment extends BaseFragment<CurrentTempView, CurrentTempPresenter> implements CurrentTempView {

    @BindView(R.id.tv_city_name)
    TextView mCtityName;
    @BindView(R.id.tv_day)
    TextView mDayName;
    @BindView(R.id.tv_description)
    TextView mDescription;
    @BindView(R.id.iv_temp_icon)
    ImageView mTempIcon;
    @BindView(R.id.tv_temp)
    TextView mCurrentTemp;
    @BindView(R.id.tv_precipitation)
    TextView mPreceptation;
    @BindView(R.id.tv_humidity)
    TextView mHumidity;
    @BindView(R.id.tv_wind)
    TextView mWind;
    @BindView(R.id.tv_popular_restaurant)
    TextView mPopularRestaurant;

    private double latitude;
    private double longitude;

    public static Fragment newInstance() {

        Bundle args = new Bundle();

        Fragment fragment = new CurrentTempFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.curent_temp_layou, container, false);
        ButterKnife.bind(this, view);
        if (getArguments() != null) {
            latitude = getArguments().getDouble(Constans.LATITUDE);
            longitude = getArguments().getDouble(Constans.LONGITUDE);
            mPresenter.loadData(latitude, longitude);
        }
        return view;
    }

    @Override
    protected CurrentTempPresenter onCreatePresenter() {
        return new CurrentTempPresenter();
    }

    @Override
    protected CurrentTempView getThisView() {
        return this;
    }

    @Override
    public void onLoadCurrent(ForecastResult forecastResult) {
        mCtityName.setText(forecastResult.getLocation().getCityName());
        mDayName.setText(dayStringFormat(forecastResult.getLocation().getLocalTime()));
        mDescription.setText(forecastResult.getCurrent().getCondition().getText());
        if (getActivity() != null) {
            Glide.with(getActivity()).load("http:" + forecastResult.getCurrent().getCondition().getImageUrl()).into(mTempIcon);
        }
        mCurrentTemp.setText(String.valueOf(forecastResult.getCurrent().getTempCelsius()));
        mPreceptation.setText(String.valueOf(forecastResult.getCurrent().getPrecipition()));
        mHumidity.setText(String.valueOf(forecastResult.getCurrent().getHumidity()));
        mWind.setText(String.valueOf(forecastResult.getCurrent().getWindKPH()));

        mPopularRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "TO DO onClick", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private String dayStringFormat(String date) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, Integer.valueOf(date.substring(5, 7))-1);
        cal.set(Calendar.DAY_OF_MONTH, Integer.valueOf(date.substring(8, 10)));
        cal.set(Calendar.YEAR, Integer.valueOf(date.substring(0, 4)));

        int dow = cal.get(Calendar.DAY_OF_WEEK);
        switch (dow) {
            case Calendar.MONDAY:
                return "Monday";
            case Calendar.TUESDAY:
                return "Tuesday";
            case Calendar.WEDNESDAY:
                return "Wednesday";
            case Calendar.THURSDAY:
                return "Thursday";
            case Calendar.FRIDAY:
                return "Friday";
            case Calendar.SATURDAY:
                return "Saturday";
            case Calendar.SUNDAY:
                return "Sunday";
        }
        return "Unknown";
    }
}
