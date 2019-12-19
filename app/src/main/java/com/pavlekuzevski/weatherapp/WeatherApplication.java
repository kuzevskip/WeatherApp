package com.pavlekuzevski.weatherapp;

import android.app.Application;

import com.pavlekuzevski.weatherapp.di.component.DaggerApplicationComponent;

public class WeatherApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DaggerApplicationComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }
}
