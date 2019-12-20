package com.pavlekuzevski.weatherapp.utils.binding;

import android.util.Log;

import com.pavlekuzevski.weatherapp.data.model.DarkSky.ForecastData;
import com.pavlekuzevski.weatherapp.ui.report.ReportListAdapter;

import java.util.List;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class BindingUtils {

    public static final String TAG = BindingUtils.class.getSimpleName();

    @BindingAdapter({"adapter_items"})
    public static void addForecastItems(RecyclerView recyclerView, List<ForecastData> data) {
        Log.d(TAG, "Update forecast report. Number of items " + (data != null ? data.size() : 0));
        ReportListAdapter adapter = (ReportListAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(data);
        }
    }
}
