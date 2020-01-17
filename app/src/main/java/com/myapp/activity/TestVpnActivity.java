package com.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

import com.google.common.util.concurrent.ServiceManager;
import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityTestVpnBinding;
import com.myapp.databinding.ActivityVpnBinding;
import com.myapp.utils.LogUtils;
import com.myapp.vpn.VpnUtil;

import java.lang.reflect.Field;

public class TestVpnActivity extends BaseActivity<ActivityTestVpnBinding> implements View.OnClickListener {
    private static Class vpnProfileClz;
    private static Class credentialsClz;
    private static Class keyStoreClz;
    private static Class iConManagerClz;
    private static Object iConManagerObj;



    @Override
    protected void initView() {
       binding.setClick(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test_vpn;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.connect_vpn:
                VpnUtil.init(this);
                Object vpnProfile = VpnUtil.createVpnProfile("pp", "sshk.263nt.com", "hli", "50936hp@bj.office");
                long stime= System.currentTimeMillis();
                boolean connect = VpnUtil.connect(this, vpnProfile);
                long difTime=System.currentTimeMillis()-stime;
                LogUtils.d("打印时间哈"+difTime+"---"+connect);
                break;
        }
    }
}
