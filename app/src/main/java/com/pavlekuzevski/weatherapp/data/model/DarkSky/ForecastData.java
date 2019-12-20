package com.pavlekuzevski.weatherapp.data.model.DarkSky;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForecastData {
    @Expose
    @SerializedName("time")
    Long time;

    @Expose
    @SerializedName("humidity")
    Float humidity;

    @Expose
    @SerializedName("pressure")
    Double pressure;
}
