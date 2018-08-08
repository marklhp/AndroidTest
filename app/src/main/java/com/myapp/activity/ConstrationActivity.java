package com.myapp.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.myapp.R;
import com.myapp.databinding.ActivityConstrationBinding;

public class ConstrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        long time1= SystemClock.currentThreadTimeMillis();
        ActivityConstrationBinding binding=DataBindingUtil.setContentView(this,R.layout.activity_constration);
        long time2= SystemClock.currentThreadTimeMillis();
        Log.d("constration打印时间",time2-time1+"");
    }
}
