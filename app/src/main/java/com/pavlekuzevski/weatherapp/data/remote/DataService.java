package com.pavlekuzevski.weatherapp.data.remote;

import android.location.Location;

import com.pavlekuzevski.weatherapp.data.model.DarkSky.Forecast;
import com.pavlekuzevski.weatherapp.data.model.Geolocation.GeolocationResponse;

import io.reactivex.Single;

public interface DataService {
    Single<Forecast> getDailyForecast(Location location);
    Single<GeolocationResponse> getGeolocation(String address);
}
