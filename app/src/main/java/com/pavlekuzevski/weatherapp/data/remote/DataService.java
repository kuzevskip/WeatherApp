package com.pavlekuzevski.weatherapp.data.remote;

import android.location.Location;

import com.pavlekuzevski.weatherapp.data.model.DarkSky.Forecast;

import io.reactivex.Single;

public interface DataService {
    Single<Forecast> getDailyForecast(Location location);
}
