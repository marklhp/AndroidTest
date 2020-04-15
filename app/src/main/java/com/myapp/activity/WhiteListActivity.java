package com.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;

import com.google.zxing.common.detector.WhiteRectangleDetector;
import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityWhiteListBinding;
import com.myapp.utils.DeviceUtils;
import com.myapp.utils.LogUtils;
import com.myapp.utils.ThreadPoolUtil;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class WhiteListActivity extends BaseActivity<ActivityWhiteListBinding> implements View.OnClickListener {
    AtomicInteger atomicInteger=new AtomicInteger();

    @Override
    protected void initView() {
        binding.setClick(this);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_white_list;
    }

    @Override
    public void onClick(View v) {
//        List<ApplicationInfo> installedPackages = getPackageManager().getInstalledApplications(0);
//        for (ApplicationInfo applicationInfo : installedPackages) {
//            if ((applicationInfo.flags&ApplicationInfo.FLAG_SYSTEM)==ApplicationInfo.FLAG_SYSTEM&& TextUtils.equals(applicationInfo.packageName,"com.google.android.gms")){
//
//                LogUtils.d("打印应用信息"+applicationInfo.packageName);
//
//            }
//
//        }
                        LogUtils.d("打印应用信息"+DeviceUtils.isRun("com.google.android.gms"));


//        switch (v.getId()){
//            case R.id.white_list_click1:
//                handler.sendEmptyMessageDelayed(1221,3000);
//                break;
//            case R.id.white_list_click2:
//                handler.removeMessages(1221);
//                break;
//        }


    }

    @SuppressLint("HandlerLeak")
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int i = atomicInteger.get();
            atomicInteger.set(i+1);
            LogUtils.d("打印应用信息线程打印"+atomicInteger);
        }
    };

}
