package com.myapp.model;

import android.util.Log;

import androidx.lifecycle.LiveData;

public class LocalLiveData extends LiveData {
    @Override
    protected void onActive() {
        super.onActive();
        Log.d("鱼腥","jlkj");
    }

    @Override
    protected void onInactive() {
        super.onInactive();
    }
}
