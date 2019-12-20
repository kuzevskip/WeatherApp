package com.pavlekuzevski.weatherapp.ui.report;

import android.location.Location;
import android.os.Bundle;

import com.pavlekuzevski.weatherapp.BR;
import com.pavlekuzevski.weatherapp.R;
import com.pavlekuzevski.weatherapp.ViewModelProviderFactory;
import com.pavlekuzevski.weatherapp.databinding.ActivityReportBinding;
import com.pavlekuzevski.weatherapp.ui.base.BaseActivity;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProviders;

public class ReportActivity extends BaseActivity<ActivityReportBinding, ReportViewModel> implements ReportNavigator {

    ReportViewModel viewModel;

    @Inject
    ViewModelProviderFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Location location = getIntent().getParcelableExtra("location");
        viewModel.setLocation(location);
        viewModel.getWeatherReport();
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_report;
    }

    @Override
    public ReportViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this, factory).get(ReportViewModel.class);
        return viewModel;
    }
}
