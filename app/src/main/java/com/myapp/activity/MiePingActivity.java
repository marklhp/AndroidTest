package com.myapp.activity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.PowerManager;

import com.myapp.App;
import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityMiePingBinding;
import com.myapp.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class MiePingActivity extends BaseActivity<ActivityMiePingBinding> implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mProximity;
    private boolean mProximitySensingEnabled;
    private PowerManager.WakeLock mProximityWakelock;
    private PowerManager mPowerManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mie_ping);
    }

    @Override
    protected void initView() {
        mPowerManager = (PowerManager) App.context.getSystemService(Context.POWER_SERVICE);
        mProximityWakelock = mPowerManager.newWakeLock(PowerManager.PROXIMITY_SCREEN_OFF_WAKE_LOCK, "com.test:power");
        mSensorManager = (SensorManager) App.context.getSystemService(Context.SENSOR_SERVICE);
        mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        enableProximitySensing(true);
        List<Sensor> sensorList;
// 实例化传感器管理者
// 得到设置支持的所有传感器的List
        sensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        List<String> sensorNameList = new ArrayList<String>();
        for (Sensor sensor : sensorList) {
            LogUtils.d("打印所有传感器"+ sensor.getName()+"---"+sensor.getType()+"------"+sensor.getVendor());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        enableProximitySensing(false);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_mie_ping;
    }

    public void enableProximitySensing(boolean enable) {
        if (enable) {
            if (!mProximitySensingEnabled) {
                mSensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_NORMAL);
                mProximitySensingEnabled = true;
            }
        } else {
            if (mProximitySensingEnabled) {
                mSensorManager.unregisterListener(this);
                mProximitySensingEnabled = false;
                // Don't forgeting to release wakelock if held
                if (mProximityWakelock.isHeld()) {
                    mProximityWakelock.release();
                }
            }
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
//        if (event.timestamp == 0) return;
        if (isProximitySensorNearby(event)) {
            if (!mProximityWakelock.isHeld()) {
                mProximityWakelock.acquire();
//                LogUtils.d("锁定");
            }
        } else {
            if (mProximityWakelock.isHeld()) {
                mProximityWakelock.release();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        LogUtils.d("打印所有传感0器"+ sensor.getName());
    }

    public static Boolean isProximitySensorNearby(final SensorEvent event) {
        float threshold = 4.001f; // <= 4 cm is near

        final float distanceInCm = event.values[0];
        final float maxDistance = event.sensor.getMaximumRange();
        LogUtils.d("Proximity sensor report [" + distanceInCm + "] , for max range [" + maxDistance + "]");

        if (maxDistance <= threshold) {
            // Case binary 0/1 and short sensors
            threshold = maxDistance;
        }
        return distanceInCm < threshold;
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.d("打印声明周期onPause");
    }
}
