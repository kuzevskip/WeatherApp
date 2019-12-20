package com.pavlekuzevski.weatherapp;

import com.pavlekuzevski.weatherapp.data.remote.DataService;
import com.pavlekuzevski.weatherapp.ui.main.MainViewModel;
import com.pavlekuzevski.weatherapp.ui.report.ReportViewModel;
import com.pavlekuzevski.weatherapp.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

@Singleton
public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

    private DataService dataService;
    private SchedulerProvider schedulerProvider;

    @Inject
    public ViewModelProviderFactory(DataService dataService,
                                    SchedulerProvider schedulerProvider) {
        this.dataService = dataService;
        this.schedulerProvider = schedulerProvider;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            //noinspection unchecked
            return (T) new MainViewModel(dataService, schedulerProvider);
        }
        if (modelClass.isAssignableFrom(ReportViewModel.class)) {
            //noinspection unchecked
            return (T) new ReportViewModel(dataService, schedulerProvider);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
