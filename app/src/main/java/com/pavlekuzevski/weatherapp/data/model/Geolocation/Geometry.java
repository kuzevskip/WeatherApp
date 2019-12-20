package com.pavlekuzevski.weatherapp.data.model.Geolocation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Geometry {
    @Expose
    @SerializedName("location")
    Location location;

    public Location getLocation() {
        return location;
    }
}
