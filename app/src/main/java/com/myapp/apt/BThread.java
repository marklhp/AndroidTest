package com.myapp.apt;

import android.os.SystemClock;

import com.myapp.utils.LogUtils;

public class BThread {
    public static void get(){
        synchronized (Test.class){
            LogUtils.d("测试-------b"+SystemClock.currentThreadTimeMillis());
        }
    }
}
