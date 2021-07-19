package com.myapp.receiver;

import android.util.Log;

import androidx.annotation.NonNull;

public class MyExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(@NonNull Thread t, @NonNull Throwable e) {
        Log.d("异常打印"+t.getName()+"=========","==+++");
    }
}
