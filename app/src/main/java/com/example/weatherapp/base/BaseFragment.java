package com.example.weatherapp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public abstract class BaseFragment <V extends BaseView, P extends BasePresenter<V>>
        extends Fragment implements BaseView {

    protected P mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = onCreatePresenter();
        mPresenter.setView(getThisView());
    }

    protected abstract P onCreatePresenter();

    protected abstract V getThisView();

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDetach();
    }
}

