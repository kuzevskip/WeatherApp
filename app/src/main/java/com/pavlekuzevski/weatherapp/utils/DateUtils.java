package com.pavlekuzevski.weatherapp.utils;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    public static String epochToDate(long seconds){
        Date date = new Date(seconds*1000);
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
        return format.format(date);
    }
}
