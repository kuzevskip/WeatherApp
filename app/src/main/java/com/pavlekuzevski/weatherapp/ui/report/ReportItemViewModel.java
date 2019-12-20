package com.pavlekuzevski.weatherapp.ui.report;

import com.pavlekuzevski.weatherapp.data.model.DarkSky.ForecastData;
import com.pavlekuzevski.weatherapp.utils.DateUtils;

import androidx.databinding.ObservableField;

public class ReportItemViewModel {

    public final ObservableField<String> summary;
    public final ObservableField<String> date;
    public final ObservableField<String> humidity;
    public final ObservableField<String> highestTemperature;
    public final ObservableField<String> lowestTemperature;
    public final ObservableField<String> pressure;
    public final ObservableField<String> precipitation;

    ReportItemViewModel(ForecastData data){
        summary = new ObservableField<>(data.getSummary());
        date = new ObservableField<>(DateUtils.epochToDate(data.getTime()));
        humidity = new ObservableField<>(data.getHumidity()*100 + "%");
        highestTemperature = new ObservableField<>(data.getTemperatireHighest() + "°F");
        lowestTemperature = new ObservableField<>(data.getTemperatureLowest() + "°F");
        pressure = new ObservableField<>(data.getPressure() + "kPa");
        precipitation = new ObservableField<>(data.getPrecipiationProbability()*100 + "%");
    }
}
