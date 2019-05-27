package com.example.weatherapp.base;

public interface Presenter<V extends BaseView>  {


    void setView(V mView);

    void onDetach();
}
