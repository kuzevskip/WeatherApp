package com.pavlekuzevski.weatherapp.di.module;

import android.app.Application;
import android.content.Context;


import com.pavlekuzevski.weatherapp.BuildConfig;
import com.pavlekuzevski.weatherapp.data.remote.DarkSkyRetrofitService;
import com.pavlekuzevski.weatherapp.data.remote.ApplicationDataService;
import com.pavlekuzevski.weatherapp.data.remote.DataService;
import com.pavlekuzevski.weatherapp.data.remote.GeocodingRetrofitService;
import com.pavlekuzevski.weatherapp.utils.rx.ApplicationSchedulerProvider;
import com.pavlekuzevski.weatherapp.utils.rx.SchedulerProvider;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {
    public static final String DARKSKY = "DarkSky";
    public static final String GEOCODING = "Geocoding";

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Singleton
    @Provides
    @Named(DARKSKY)
    static Retrofit provideForecastRetrofit() {
        return new Retrofit.Builder().baseUrl(BuildConfig.DARK_SKY_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    static DarkSkyRetrofitService provideDarkSkyRetrofitService(@Named(DARKSKY) Retrofit retrofit) {
        return retrofit.create(DarkSkyRetrofitService.class);
    }

    @Singleton
    @Provides
    @Named(GEOCODING)
    static Retrofit provideGeocodingRetrofit() {
        return new Retrofit.Builder().baseUrl(BuildConfig.GEOCODING_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    static GeocodingRetrofitService provideGeocodingRetrofitService(@Named(GEOCODING) Retrofit retrofit) {
        return retrofit.create(GeocodingRetrofitService.class);
    }

    @Provides
    @Singleton
    DataService provideDataRepository(ApplicationDataService dataService) { return dataService;}

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new ApplicationSchedulerProvider();
    }

}
