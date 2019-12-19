package com.pavlekuzevski.weatherapp.ui.report;

import android.os.Bundle;

import com.pavlekuzevski.weatherapp.BR;
import com.pavlekuzevski.weatherapp.R;
import com.pavlekuzevski.weatherapp.databinding.ActivityReportBinding;
import com.pavlekuzevski.weatherapp.ui.base.BaseActivity;

import androidx.lifecycle.ViewModelProviders;

public class ReportActivity extends BaseActivity<ActivityReportBinding, ReportViewModel> implements ReportNavigator {

    ReportViewModel reportViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        reportViewModel = ViewModelProviders.of(this).get(ReportViewModel.class);
        return reportViewModel;
    }
}
