package com.myapp.utils;

import android.app.ActivityManager;

import com.myapp.App;

import static android.content.Context.ACTIVITY_SERVICE;

public class MemoryInfoUtils {

    public static void getMemoryInfo(){
        ActivityManager activityManager = (ActivityManager) App.context.getSystemService(ACTIVITY_SERVICE);
        //最大分配内存
        int memory = activityManager.getMemoryClass();
        System.out.println("memory: "+memory);
        //最大分配内存获取方法2
        float maxMemory = (float) (Runtime.getRuntime().maxMemory() * 1.0/ (1024 * 1024));
        //当前分配的总内存
        float totalMemory = (float) (Runtime.getRuntime().totalMemory() * 1.0/ (1024 * 1024));
        //剩余内存
        float freeMemory = (float) (Runtime.getRuntime().freeMemory() * 1.0/ (1024 * 1024));




        LogUtils.d("打印maxMemory"+maxMemory);
        LogUtils.d("打印totalMemory"+totalMemory);
        LogUtils.d("打印freeMemory"+freeMemory);
    }
}
