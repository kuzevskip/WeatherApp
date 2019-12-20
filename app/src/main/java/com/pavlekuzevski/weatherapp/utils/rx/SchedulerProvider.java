package com.pavlekuzevski.weatherapp.utils.rx;

import io.reactivex.Scheduler;

public interface SchedulerProvider {
    Scheduler io();

    Scheduler ui();
}
