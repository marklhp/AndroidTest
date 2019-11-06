package com.myapp.utils;


import android.util.Log;

public class LogUtils {
    private static final String TAG = "测试信息打印";


    public static void d(String msg) {
        if (isIsLog()) {
            Log.d(TAG,msg);
        }
    }

    public static void e(Throwable throwable) {
        if (isIsLog()&&throwable!=null) {
            Log.e(TAG,"异常信息",throwable);
        }
    }


    public static boolean isIsLog() {
        return true;
    }
}
