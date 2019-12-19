package com.pavlekuzevski.weatherapp.ui.base;

import java.lang.ref.WeakReference;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;

public class BaseViewModel<N> extends ViewModel {
    private WeakReference<N> navigator;

    private final ObservableBoolean isLoading = new ObservableBoolean();

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
}
