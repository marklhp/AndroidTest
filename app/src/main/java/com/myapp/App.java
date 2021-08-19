package com.myapp;

import android.app.Application;
import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.myapp.receiver.MyExceptionHandler;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class App extends Application {
    public static Context context;
    public static Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("打印内容=====",this.toString());
        context=this;
        application=this;
        getResources();
//        MyExceptionHandler exceptionHandler=new MyExceptionHandler();
//        Thread.setDefaultUncaughtExceptionHandler(exceptionHandler);

    }
}
