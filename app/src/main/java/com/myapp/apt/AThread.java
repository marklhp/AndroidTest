package com.myapp.apt;

import android.os.SystemClock;

import com.myapp.utils.LogUtils;

public class AThread {

    public static void get(){
        synchronized (Test.class){
            SystemClock.sleep(10000);
            LogUtils.d("测试-------a"+SystemClock.currentThreadTimeMillis());
        }
    }
}
