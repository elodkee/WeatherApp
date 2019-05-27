package com.example.weatherapp;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.weatherapp.base.BaseActivity;
import com.example.weatherapp.constant.Constans;
import com.example.weatherapp.navigation.AppNavigator;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity<MainView, MainPresenter> implements NavigationView.OnNavigationItemSelectedListener,
        MainView {

    private LocationManager locationManager;
    private String lattitudeS, longitudes;
    double lattitude;
    double longitude;
    private static final int REQUEST_LOCATION = 1;

    @BindView(R.id.nav_view)
    NavigationView mNavigationView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawer;

    @Inject
    AppNavigator mNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.app().getComponent().inject(this);
        ButterKnife.bind(this);
        setActionBar();
        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (locationManager != null) {
            if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                buildAlertMessageNoGps();
            } else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                getLocation();
            }
        }
        Bundle args = new Bundle();
        args.putDouble(Constans.LATITUDE, lattitude);
        args.putDouble(Constans.LONGITUDE, longitude);
        mNavigator.showFragment(getSupportFragmentManager(), Constans.HOME_FRAGMENT, args);
    }

    @Override
    protected MainPresenter onCreatePresenter() {
        return new MainPresenter();
    }

    @Override
    protected MainView getView() {
        return this;
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
            getLocation();

        } else {
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            Location location1 = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            Location location2 = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);

            if (location != null) {
                lattitude = location.getLatitude();
                longitude = location.getLongitude();
                lattitudeS = String.valueOf(lattitude);
                longitudes = String.valueOf(longitude);
            } else if (location1 != null) {
                lattitude = location.getLatitude();
                longitude = location.getLongitude();
                lattitudeS = String.valueOf(lattitude);
                longitudes = String.valueOf(longitude);
            } else if (location2 != null) {
                lattitude = location.getLatitude();
                longitude = location.getLongitude();
                lattitudeS = String.valueOf(lattitude);
                longitudes = String.valueOf(longitude);
            } else {

                Toast.makeText(this, "Unble to Trace your location", Toast.LENGTH_SHORT).show();

            }
        }
    }

    private void setActionBar() {
        setSupportActionBar(mToolbar);
        setTitle("");
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        mNavigationView.setNavigationItemSelectedListener(this);
        toggle.syncState();
    }

    protected void buildAlertMessageNoGps() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Please Turn ON your GPS Connection")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.new_page:
                mNavigator.showFragment(getSupportFragmentManager(), Constans.NEW_FRAGMENT, new Bundle());
            default:
                break;
        }
        mDrawer.closeDrawer(GravityCompat.START);
        return false;
    }
}
