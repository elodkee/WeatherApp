package com.example.weatherapp.newfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weatherapp.R;
import com.example.weatherapp.base.BaseFragment;

public class NewFragment extends BaseFragment<NewView,NewPresenter> implements NewView {

    public static NewFragment newInstance() {
        
        Bundle args = new Bundle();
        
        NewFragment fragment = new NewFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.new_layout, container,false);
        return view;
    }

    @Override
    protected NewPresenter onCreatePresenter() {
        return new NewPresenter();
    }

    @Override
    protected NewView getThisView() {
        return this;
    }
}
