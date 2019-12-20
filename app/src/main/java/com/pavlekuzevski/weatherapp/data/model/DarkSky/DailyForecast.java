package com.pavlekuzevski.weatherapp.data.model.DarkSky;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DailyForecast {
    @Expose
    @SerializedName("summary")
    String summary;

    @Expose
    @SerializedName("icon")
    String icon;

    @Expose
    @SerializedName("data")
    List<ForecastData> data;

    public List<ForecastData> getData() {
        return data;
    }
}
