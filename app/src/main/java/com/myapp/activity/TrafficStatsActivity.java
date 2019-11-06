package com.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.TrafficStats;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityTrafficStatsBinding;

import java.util.List;

public class TrafficStatsActivity extends BaseActivity<ActivityTrafficStatsBinding> implements View.OnClickListener {


    long pre_value;
    long dif_value;
    @Override
    protected void initView() {
        binding.setClick(this);
        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        ApplicationInfo appinfo = getApplicationInfo();
        List<ActivityManager.RunningAppProcessInfo> run = am.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo runningProcess : run) {
//            if ((runningProcess.processName != null) && runningProcess.processName.equals(appinfo.processName)) {
//
//                break;
//            }
            Log.v("===========",runningProcess.processName+"==="+ String.valueOf(runningProcess.uid));
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_traffic_stats;
    }

    @Override
    public void onClick(View v) {
        TrafficStats.getTotalRxBytes();
        TrafficStats.getTotalTxBytes();
//        binding.setFlowValue();

    }
}
