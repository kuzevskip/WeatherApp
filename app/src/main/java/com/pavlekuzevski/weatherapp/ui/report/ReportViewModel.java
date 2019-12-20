package com.pavlekuzevski.weatherapp.ui.report;

import android.location.Location;
import android.util.Log;

import com.pavlekuzevski.weatherapp.data.model.DarkSky.ForecastData;
import com.pavlekuzevski.weatherapp.data.remote.DataService;
import com.pavlekuzevski.weatherapp.ui.base.BaseViewModel;
import com.pavlekuzevski.weatherapp.utils.rx.SchedulerProvider;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ReportViewModel extends BaseViewModel<ReportNavigator> {

    public static final String TAG = ReportViewModel.class.getSimpleName();

    private final MutableLiveData<Location> location;

    private final MutableLiveData<String> address;

    private final MutableLiveData<List<ForecastData>> forecastItems;

    public ReportViewModel(DataService dataService, SchedulerProvider schedulerProvider) {
        super(dataService, schedulerProvider);
        location = new MutableLiveData<>();
        forecastItems = new MutableLiveData<>();
        address = new MutableLiveData<>();
    }

    public void getWeatherReport() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataService().getDailyForecast(location.getValue()).
                subscribeOn(getSchedulerProvider().io()).
                observeOn(getSchedulerProvider().ui()).
                subscribe(forecast -> {
                    int size = forecast.getDailyForecast().getData().size();
                    Log.d(TAG, "Received forecast data. Number of items " + size);
                    setIsLoading(false);
                    forecastItems.setValue(forecast.getDailyForecast().getData());
                }, throwable -> {
                    Log.e(TAG, "Receiving forecast data error", throwable);
                    setIsLoading(false);
                }));
    }

    public void setLocation(Location location) {
        this.location.setValue(location);
    }

    public LiveData<List<ForecastData>> getForecastItems() {
        return forecastItems;
    }

    public void setAddress(String address) {
        this.address.setValue(address);
    }

    public LiveData<String> getAddress() {
        return address;
    }
}
