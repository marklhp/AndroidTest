package com.myapp.utils;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

public class DeviceUtils {

    public static boolean isMiui(){
        String brand=Build.BRAND;
        Log.d("系统定制厂商",brand);
        return "Xiaomi".equalsIgnoreCase(brand)||"miui".equalsIgnoreCase(brand);
    }

    public static boolean isFlyme() {
        String brand=Build.BRAND;
        Log.d("系统定制厂商",brand);
        return "meizu".equalsIgnoreCase(brand)||"flyme".equalsIgnoreCase(brand);
    }
}
