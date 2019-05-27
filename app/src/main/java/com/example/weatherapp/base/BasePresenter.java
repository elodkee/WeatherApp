package com.example.weatherapp.base;

public abstract class BasePresenter<V extends BaseView> implements Presenter<V>{

    protected V mView;

    @Override
    public void setView(V view) {
        mView= view;
    }

    @Override
    public void onDetach() {
        mView = null;
    }
}
