package com.myapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;

import com.myapp.R;

public class FlexboxlayoutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        long time1= SystemClock.currentThreadTimeMillis();
        setContentView(R.layout.activity_flexboxlayout);
        long time2= SystemClock.currentThreadTimeMillis();
        Log.d("flexbox打印时间",time2-time1+"");
    }
}
