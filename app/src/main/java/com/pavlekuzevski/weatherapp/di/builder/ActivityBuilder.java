package com.pavlekuzevski.weatherapp.di.builder;

import com.pavlekuzevski.weatherapp.ui.main.MainActivity;
import com.pavlekuzevski.weatherapp.ui.report.ReportActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector()
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector()
    abstract ReportActivity bindReportActivity();
}
