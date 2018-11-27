package com.myapp.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;

import com.myapp.App;

import java.math.BigDecimal;
import java.util.List;


/**
 * Created by lihaipeng on 2018/5/24.
 */

public class DivideUtils {
    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入。
     * @param v1 被除数
     * @param v2 除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(double v1,double v2,int scale){
        if (scale<0){
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1=new BigDecimal(Double.toString(v1));
        BigDecimal b2=new BigDecimal(Double.toString(v2));

        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static String getTopActivityInfo() {
        String processName = null;

        ActivityManager manager = ((ActivityManager) App.context.getSystemService(Context.ACTIVITY_SERVICE));
        if (Build.VERSION.SDK_INT >= 21) {
            List<ActivityManager.RunningAppProcessInfo> pis = manager.getRunningAppProcesses();
            ActivityManager.RunningAppProcessInfo topAppProcess = pis.get(0);
            if (topAppProcess != null && topAppProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                processName = topAppProcess.processName;
            }
        } else {
            //getRunningTasks() is deprecated since API Level 21 (Android 5.0)
            List localList = manager.getRunningTasks(1);
            ActivityManager.RunningTaskInfo localRunningTaskInfo = (ActivityManager.RunningTaskInfo)localList.get(0);
            processName = localRunningTaskInfo.topActivity.getPackageName();
            processName =processName+"------"+ localRunningTaskInfo.topActivity.getClassName();
        }
        return processName;
    }
}
