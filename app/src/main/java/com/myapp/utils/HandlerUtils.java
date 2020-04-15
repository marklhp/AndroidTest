package com.myapp.utils;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

import java.util.concurrent.atomic.AtomicInteger;

public class HandlerUtils {
    private static AtomicInteger atomicInteger=new AtomicInteger();
    public static int messPush=1010;//收到推送消息
    @SuppressLint("HandlerLeak")
    public static Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int i = atomicInteger.get();
            atomicInteger.set(i+1);
            LogUtils.d("打印应用信息线程打印"+atomicInteger);
        }
    };
}
