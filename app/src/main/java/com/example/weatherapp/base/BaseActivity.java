package com.example.weatherapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>>
        extends AppCompatActivity implements BaseView {

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = onCreatePresenter();
        mPresenter.setView(getView());
    }

    protected abstract P onCreatePresenter();

    protected abstract V getView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDetach();
    }
}
