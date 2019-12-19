package com.pavlekuzevski.weatherapp.ui.main;

import android.content.Intent;
import android.os.Bundle;

import com.pavlekuzevski.weatherapp.BR;
import com.pavlekuzevski.weatherapp.R;

import com.pavlekuzevski.weatherapp.databinding.ActivityMainBinding;
import com.pavlekuzevski.weatherapp.ui.base.BaseActivity;
import com.pavlekuzevski.weatherapp.ui.report.ReportActivity;

import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainNavigator{

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainViewModel.setNavigator(this);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public MainViewModel getViewModel() {
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        return mainViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void showWeatherReport() {
        Intent intent = new Intent(MainActivity.this, ReportActivity.class);
        startActivity(intent);
    }
}
