package com.pavlekuzevski.weatherapp.data.model.DarkSky;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forecast {
    @Expose
    @SerializedName("latitude")
    Float latitude;

    @Expose
    @SerializedName("longitude")
    Float longitude;

    @Expose
    @SerializedName("timezone")
    String timezone;

    @Expose
    @SerializedName("daily")
    DailyForecast dailyForecast;
}
