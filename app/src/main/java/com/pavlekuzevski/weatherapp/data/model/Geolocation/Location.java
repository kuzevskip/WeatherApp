package com.pavlekuzevski.weatherapp.data.model.Geolocation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {
    @Expose
    @SerializedName("lat")
    Double latitude;

    @Expose
    @SerializedName("lng")
    Double longitude;

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
