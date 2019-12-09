package com.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;

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

import org.linphone.mediastream.Log;

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
        if (event.timestamp == 0) return;
        if (isProximitySensorNearby(event)) {
            if (!mProximityWakelock.isHeld()) {
                mProximityWakelock.acquire();
                LogUtils.d("锁定");
            }
        } else {
            if (mProximityWakelock.isHeld()) {
                mProximityWakelock.release();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

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
}
