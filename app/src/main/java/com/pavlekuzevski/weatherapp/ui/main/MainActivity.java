package com.pavlekuzevski.weatherapp.ui.main;

import android.os.Bundle;

import com.pavlekuzevski.weatherapp.BR;
import com.pavlekuzevski.weatherapp.R;

import com.pavlekuzevski.weatherapp.ui.base.BaseActivity;
import com.pavlekuzevski.weatherapp.ui.base.BaseViewModel;

import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends BaseActivity {

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public BaseViewModel getViewModel() {
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        return mainViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
}
