package com.myapp.utils.glide;

import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Printer;
import android.view.TextureView;

public class DelayedUIUtils {
    static long preTime;
    static long nextTime;
    public static void checkTime(){
        Looper.getMainLooper().setMessageLogging(new Printer() {
            @Override
            public void println(String x) {
                if (x!=null&&x.startsWith(">>>>> Dispatching to")){
                    preTime=SystemClock.currentThreadTimeMillis();
                }else if (x!=null&&x.startsWith("<<<<< Finished to")){
                    nextTime=SystemClock.currentThreadTimeMillis();
                    Log.d("打印时间差",(nextTime-preTime)+"");
                }
            }
        });
    }
}
