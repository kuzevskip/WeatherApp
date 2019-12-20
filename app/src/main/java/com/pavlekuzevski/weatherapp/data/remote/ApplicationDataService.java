package com.pavlekuzevski.weatherapp.data.remote;

import android.location.Location;

import com.pavlekuzevski.weatherapp.data.model.DarkSky.Forecast;
import com.pavlekuzevski.weatherapp.utils.remote.ApiKeys;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class ApplicationDataService implements DataService{
    private DarkSkyRetrofitService darkSkyRetrofitService;

    @Inject
    ApplicationDataService(DarkSkyRetrofitService darkSkyRetrofitService){
        this.darkSkyRetrofitService = darkSkyRetrofitService;
    }

    @Override
    public Single<Forecast> getDailyForecast(Location location){
        return darkSkyRetrofitService.getDailyForecast(ApiKeys.DARKSKY_API_KEY,
                location.getLatitude(), location.getLongitude(), "[currently,minutely,hourly,flags, offset]");
    }
}
