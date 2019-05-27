package com.example.weatherapp.home.viewpager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weatherapp.R;
import com.example.weatherapp.base.BaseFragment;
import com.example.weatherapp.home.viewpager.fragment.CurrentTempFragment;
import com.example.weatherapp.home.viewpager.presenter.ContentPresenter;
import com.example.weatherapp.home.viewpager.view.ContentView;
import com.example.weatherapp.newfragment.NewFragment;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContentFragment extends BaseFragment<ContentView, ContentPresenter> implements ContentView {

    public static final String TAG = ContentFragment.class.getSimpleName();
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;

    public static ContentFragment newInstance() {

        Bundle args = new Bundle();

        ContentFragment fragment = new ContentFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.content_layout, container, false);
        ButterKnife.bind(this, view);
        if (getActivity() != null) {


            ArrayList<Fragment> fragments = new ArrayList<>();
            fragments.add( CurrentTempFragment.newInstance());
            fragments.get(0).setArguments(getArguments());
            fragments.add( NewFragment.newInstance());
            PagerAdapter adapter = new PagerAdapter(getActivity().getSupportFragmentManager(), fragments);
            mViewPager.setAdapter(adapter);
            mTabLayout.setupWithViewPager(mViewPager, true);
            mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    mViewPager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        }
        return view;
    }

    @Override
    protected ContentPresenter onCreatePresenter() {
        return new ContentPresenter();
    }

    @Override
    protected ContentView getThisView() {
        return this;
    }
}
