package com.pavlekuzevski.weatherapp.data.model.Geolocation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GeolocationResult {
    @Expose
    @SerializedName("geometry")
    Geometry geometry;

    public Geometry getGeometry() {
        return geometry;
    }
}
