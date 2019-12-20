package com.pavlekuzevski.weatherapp.ui.report;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import dagger.Module;
import dagger.Provides;

@Module
public class ReportActivityModule {
    @Provides
    Adapter provideAdapter() {
        return new ReportListAdapter(new ArrayList<>());
    }

    @Provides
    LayoutManager provideLayoutManager(ReportActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
