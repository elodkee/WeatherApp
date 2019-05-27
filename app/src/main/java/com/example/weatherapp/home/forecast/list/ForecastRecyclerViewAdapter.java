package com.example.weatherapp.home.forecast.list;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.weatherapp.R;
import com.example.weatherapp.data.model.Forecastday;

import java.util.ArrayList;
import java.util.Calendar;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ForecastRecyclerViewAdapter extends
        RecyclerView.Adapter<ForecastRecyclerViewAdapter.ForecastViewHolder> {

    private ArrayList<Forecastday> mForecast;
    private Activity mContext;

    public ForecastRecyclerViewAdapter(Activity context, ArrayList<Forecastday> forecast) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.forecast_day, viewGroup, false);
        return new ForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForecastViewHolder viewHolder, int i) {
        if (mForecast != null && mForecast.get(i) != null) {
            String celsiusCharacter = "°";
            viewHolder.mDayName.setText(dayStringFormat(mForecast.get(i).getDate()));
            String url = mForecast.get(i).getDay().getCondition().getImageUrl().substring(2);
            Glide.with(mContext).load("http:"+ url)
                    .into(viewHolder.mTempIcon);
            viewHolder.mTempMax.setText(String.valueOf((int)mForecast.get(i).getDay().getMaxtemp_c()).concat(celsiusCharacter));
            viewHolder.mTempMin.setText(String.valueOf((int)mForecast.get(i).getDay().getMintemp_c()).concat(celsiusCharacter));
        }
    }

    private String dayStringFormat(String date) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, Integer.valueOf(date.substring(5,7))-1);
        cal.set(Calendar.DAY_OF_MONTH, Integer.valueOf(date.substring(date.length()-2,date.length())));
        cal.set(Calendar.YEAR, Integer.valueOf(date.substring(0,4)));

        int dow = cal.get(Calendar.DAY_OF_WEEK);
        switch (dow) {
            case Calendar.MONDAY:
                return "MON";
            case Calendar.TUESDAY:
                return "TUE";
            case Calendar.WEDNESDAY:
                return "WED";
            case Calendar.THURSDAY:
                return "THU";
            case Calendar.FRIDAY:
                return "FRI";
            case Calendar.SATURDAY:
                return "SAT";
            case Calendar.SUNDAY:
                return "SUN";
        }

        return "Unknown";
    }


    @Override
    public int getItemCount() {
        return mForecast != null ? mForecast.size() : 0;
    }

    public void updateList(ArrayList<Forecastday> forecast) {
        this.mForecast = forecast;
        this.notifyDataSetChanged();
    }


    class ForecastViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.day_temp_max)
        TextView mTempMax;
        @BindView(R.id.day_temp_min)
        TextView mTempMin;
        @BindView(R.id.day_text)
        TextView mDayName;
        @BindView(R.id.temp_icon)
        ImageView mTempIcon;

        ForecastViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}