package com.myapp.model;

import android.os.SystemClock;

import androidx.databinding.ObservableInt;

public class CarBean {
    public ObservableInt age;
    public ObservableInt num;

    public CarBean(){
        SystemClock.sleep(2000);

    }

}
