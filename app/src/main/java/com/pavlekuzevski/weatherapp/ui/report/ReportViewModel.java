package com.pavlekuzevski.weatherapp.ui.report;

import android.location.Location;

import com.pavlekuzevski.weatherapp.data.remote.DataService;
import com.pavlekuzevski.weatherapp.ui.base.BaseViewModel;
import com.pavlekuzevski.weatherapp.utils.rx.SchedulerProvider;

public class ReportViewModel extends BaseViewModel<ReportNavigator> {

    public ReportViewModel(DataService dataService, SchedulerProvider schedulerProvider){
        super(dataService, schedulerProvider);
        setIsLoading(true);
        Location location = new Location("");
        location.setLatitude(37.8267);
        location.setLongitude(-122.4233);
        getCompositeDisposable().add(dataService.getDailyForecast(location).
                subscribeOn(schedulerProvider.io()).
                observeOn(schedulerProvider.ui()).
                subscribe(forecast -> {
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                }));

    }
}
