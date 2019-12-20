package com.pavlekuzevski.weatherapp.data.remote;

import com.pavlekuzevski.weatherapp.data.model.Geolocation.GeolocationResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GeocodingRetrofitService {
    @GET("maps/api/geocode/json")
    Single<GeolocationResponse> getGeolocation(@Query("address") String address, @Query("key") String apiKey);
}
