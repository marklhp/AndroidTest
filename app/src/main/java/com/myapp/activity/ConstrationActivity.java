package com.myapp.activity;

import android.app.Activity;
import android.os.SystemClock;
import android.os.Bundle;
import android.util.Log;

import com.myapp.R;
import com.myapp.databinding.ActivityConstrationBinding;

import androidx.databinding.DataBindingUtil;


public class ConstrationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        long time1= SystemClock.currentThreadTimeMillis();
        ActivityConstrationBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_constration);
        long time2= SystemClock.currentThreadTimeMillis();
        Log.d("constration打印时间",time2-time1+"");
    }
}
