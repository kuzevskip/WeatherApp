package com.pavlekuzevski.weatherapp.di.component;

import android.app.Application;

import com.pavlekuzevski.weatherapp.WeatherApplication;
import com.pavlekuzevski.weatherapp.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, ApplicationModule.class})
public interface ApplicationComponent {

    void inject(WeatherApplication application);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }
}
