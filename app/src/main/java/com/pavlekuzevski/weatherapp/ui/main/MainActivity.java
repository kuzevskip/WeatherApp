package com.pavlekuzevski.weatherapp.ui.main;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.pavlekuzevski.weatherapp.BR;
import com.pavlekuzevski.weatherapp.R;

import com.pavlekuzevski.weatherapp.ViewModelProviderFactory;
import com.pavlekuzevski.weatherapp.databinding.ActivityMainBinding;
import com.pavlekuzevski.weatherapp.ui.base.BaseActivity;
import com.pavlekuzevski.weatherapp.ui.report.ReportActivity;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainNavigator{

    private MainViewModel viewModel;

    @Inject
    ViewModelProviderFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.setNavigator(this);
        setupLocationEditText();
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public MainViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel.class);
        return viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    private void setupLocationEditText(){
        getViewDataBinding().locationEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                viewModel.setAddress(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void showWeatherReport(Location location) {
        Intent intent = new Intent(MainActivity.this, ReportActivity.class);
        intent.putExtra("location", location);
        startActivity(intent);
    }

    @Override
    public void showError(String message) {

    }
}
