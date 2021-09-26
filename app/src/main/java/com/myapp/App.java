package com.myapp;

import android.app.Application;
import android.content.Context;
import android.util.Log;

public class App extends Application {
    public static Context context;
    public static Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("打印内容=====",this+"");
        context=this;
        application=this;
        getResources();
//        MyExceptionHandler exceptionHandler=new MyExceptionHandler();
//        Thread.setDefaultUncaughtExceptionHandler(exceptionHandler);
//        listenReportGenerateStatus();
    }

//    public void listenReportGenerateStatus() {
//        KOOM.getInstance().setHeapReportUploader(file -> {
//            // Upload the report or do something else.
//            // File is deleted automatically when callback is done by default.
//            Log.d("内存问题打印","==="+file.getPath());
//        });
//    }
}
