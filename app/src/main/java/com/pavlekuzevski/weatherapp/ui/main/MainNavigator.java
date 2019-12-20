package com.pavlekuzevski.weatherapp.ui.main;

import android.location.Location;

public interface MainNavigator {
    void showWeatherReport(Location geolocation, String address);
    void showError(String message);
}
