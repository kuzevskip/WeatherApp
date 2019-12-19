package com.pavlekuzevski.weatherapp.ui.main;

import com.pavlekuzevski.weatherapp.ui.base.BaseViewModel;

public class MainViewModel extends BaseViewModel<MainNavigator> {

    public void getWeatherReport(){
        getNavigator().showWeatherReport();
    }
}
