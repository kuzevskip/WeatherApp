package com.pavlekuzevski.weatherapp.data.remote;

import com.pavlekuzevski.weatherapp.data.model.DarkSky.Forecast;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DarkSkyRetrofitService {
    @GET("forecast/{apiKey}/{latitude},{longitude}")
    Single<Forecast> getDailyForecast(@Path("apiKey") String apiKey,
                                      @Path("latitude") double latitude,
                                      @Path("longitude") double longitude);

    @GET("forecast/{apiKey}/{latitude},{longitude}")
    Single<Forecast> getDailyForecast(@Path("apiKey") String apiKey,
                                      @Path("latitude") double latitude,
                                      @Path("longitude") double longitude,
                                      @Query("exclude") String exclude);
}
