package com.pavlekuzevski.weatherapp.ui.base;

import com.pavlekuzevski.weatherapp.data.remote.DataService;
import com.pavlekuzevski.weatherapp.utils.rx.SchedulerProvider;

import java.lang.ref.WeakReference;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel<N> extends ViewModel {

    private DataService dataService;
    private SchedulerProvider schedulerProvider;
    private CompositeDisposable compositeDisposable;

    public BaseViewModel(DataService dataService, SchedulerProvider schedulerProvider){
        this.dataService = dataService;
        this.schedulerProvider = schedulerProvider;
        compositeDisposable = new CompositeDisposable();
    }

    public BaseViewModel(){

    }

    private WeakReference<N> navigator;

    private final ObservableBoolean isLoading = new ObservableBoolean();

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    public DataService getDataService() {
        return dataService;
    }

    public SchedulerProvider getSchedulerProvider() {
        return schedulerProvider;
    }

    public ObservableBoolean getIsLoading() {
        return isLoading;
    }

    public void setIsLoading(boolean isLoading) {
        this.isLoading.set(isLoading);
    }

    public N getNavigator() {
        return navigator.get();
    }

    public void setNavigator(N navigator) {
        this.navigator = new WeakReference<>(navigator);
    }

    @Override
    protected void onCleared() {
        compositeDisposable.dispose();
        super.onCleared();
    }
}
