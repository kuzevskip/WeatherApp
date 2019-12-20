package com.pavlekuzevski.weatherapp.data.model.Geolocation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import android.location.Location;

import java.util.List;

public class GeolocationResponse {

    @Expose
    @SerializedName("results")
    List<GeolocationResult> results;

    public Location getLocation(){
        Location location = new Location("");
        if(results != null && !results.isEmpty()){
            location.setLongitude(results.get(0).getGeometry().getLocation().getLongitude());
            location.setLatitude(results.get(0).getGeometry().getLocation().getLatitude());
        }
        return location;
    }

    public String getAddress(){
        return results != null && !results.isEmpty() ? results.get(0).getAddress() : "";
    }
}
