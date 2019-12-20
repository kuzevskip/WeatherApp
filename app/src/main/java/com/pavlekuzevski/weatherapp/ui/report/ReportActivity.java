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
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

public class ReportActivity extends BaseActivity<ActivityReportBinding, ReportViewModel> implements ReportNavigator {

    ReportViewModel viewModel;

    ActivityReportBinding binding;

    @Inject
    ViewModelProviderFactory factory;

    @Inject
    LayoutManager layoutManager;

    @Inject
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Location location = getIntent().getParcelableExtra("location");
        String address = getIntent().getStringExtra("address");
        viewModel.setLocation(location);
        viewModel.setAddress(address);
        viewModel.getWeatherReport();
        setupRecyclerView();
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

    private void setupRecyclerView(){
        binding = getViewDataBinding();
        binding.reportRecyclerView.setLayoutManager(layoutManager);
        binding.reportRecyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.reportRecyclerView.setAdapter(adapter);
    }
}
