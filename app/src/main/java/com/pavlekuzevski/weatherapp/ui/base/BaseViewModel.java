package com.pavlekuzevski.weatherapp.ui.base;

import java.lang.ref.WeakReference;

import androidx.lifecycle.ViewModel;

public class BaseViewModel<N> extends ViewModel {
    private WeakReference<N> navigator;

    public N getNavigator() {
        return navigator.get();
    }

    public void setNavigator(N navigator) {
        this.navigator = new WeakReference<>(navigator);
    }
}
