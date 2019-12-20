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

    @Expose
    @SerializedName("precipProbability")
    Float precipiationProbability;

    @Expose
    @SerializedName("temperatureHigh")
    Float temperatireHighest;

    @Expose
    @SerializedName("temperatureLow")
    Float temperatureLowest;

    @Expose
    @SerializedName("summary")
    String summary;

    public Long getTime() {
        return time;
    }

    public Float getHumidity() {
        return humidity;
    }

    public Double getPressure() {
        return pressure;
    }

    public Float getPrecipiationProbability() {
        return precipiationProbability;
    }

    public Float getTemperatireHighest() {
        return temperatireHighest;
    }

    public Float getTemperatureLowest() {
        return temperatureLowest;
    }

    public String getSummary() {
        return summary;
    }
}
