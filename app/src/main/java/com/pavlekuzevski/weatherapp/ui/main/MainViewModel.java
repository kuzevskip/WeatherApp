package com.pavlekuzevski.weatherapp.ui.main;

import com.pavlekuzevski.weatherapp.data.remote.DataService;
import com.pavlekuzevski.weatherapp.ui.base.BaseViewModel;
import com.pavlekuzevski.weatherapp.utils.rx.SchedulerProvider;

import androidx.lifecycle.MutableLiveData;

public class MainViewModel extends BaseViewModel<MainNavigator> {

    private final MutableLiveData<String> address;

    public MainViewModel(DataService dataService, SchedulerProvider schedulerProvider) {
        super(dataService, schedulerProvider);
        address = new MutableLiveData<>();
    }

    public void getWeatherReport() {
        getCompositeDisposable().add(getDataService().getGeolocation(address.getValue())
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(geolocationResponse -> {
                    setIsLoading(false);
                    getNavigator().showWeatherReport(geolocationResponse.getLocation());
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().showError(throwable.getMessage());
                }));
    }

    public void setAddress(String address) {
        this.address.setValue(address);
    }
}
