package com.pavlekuzevski.weatherapp.ui.report;

import android.location.Location;

import com.pavlekuzevski.weatherapp.data.remote.DataService;
import com.pavlekuzevski.weatherapp.ui.base.BaseViewModel;
import com.pavlekuzevski.weatherapp.utils.rx.SchedulerProvider;

import androidx.lifecycle.MutableLiveData;

public class ReportViewModel extends BaseViewModel<ReportNavigator> {

    private MutableLiveData<Location> location;

    public ReportViewModel(DataService dataService, SchedulerProvider schedulerProvider) {
        super(dataService, schedulerProvider);
        location = new MutableLiveData<>();
    }

    public void getWeatherReport() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataService().getDailyForecast(location.getValue()).
                subscribeOn(getSchedulerProvider().io()).
                observeOn(getSchedulerProvider().ui()).
                subscribe(forecast -> {
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                }));
    }

    public void setLocation(Location location) {
        this.location.setValue(location);
    }
}
