package com.myapp.java;

import android.util.Log;
import android.view.Choreographer;

public class MyFrameCallback implements Choreographer.FrameCallback {
    private String TAG = "性能检测";
    private long lastTime = 0;

    @Override
    public void doFrame(long frameTimeNanos) {
        if (lastTime == 0) {
            //代码第一次初始化。不做检测统计。
            lastTime = frameTimeNanos;
        } else {
            long times = (frameTimeNanos - lastTime) / 1000000;
            int frames = (int) (times / 16);

            if (times > 16) {

            }
            Log.w(TAG, "UI线程超时(超过16ms):" + times + "ms" + " , 丢帧:" + frames);

            lastTime = frameTimeNanos;
        }

//
    }
}

