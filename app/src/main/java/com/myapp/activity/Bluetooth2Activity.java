package com.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityBluetooth2Binding;
import com.myapp.utils.AudioManagerUtils;
import com.myapp.utils.LogUtils;

import java.util.Set;

import io.reactivex.functions.Consumer;

public class Bluetooth2Activity extends BaseActivity<ActivityBluetooth2Binding> implements View.OnClickListener {

    BluetoothHeadset bluetoothHeadset;
    // Get the default adapter
    BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    @Override
    protected void initView() {
        binding.setClick(this);

        bluetoothAdapter.getProfileProxy(this, profileListener, BluetoothProfile.HEADSET);
        IntentFilter bluetoothFilterConn0 = new IntentFilter();
        bluetoothFilterConn0.addAction(BluetoothDevice.ACTION_ACL_CONNECTED);
        registerReceiver(receiver1, bluetoothFilterConn0);
        IntentFilter bluetoothFilterConn = new IntentFilter();
        bluetoothFilterConn.addAction(BluetoothDevice.ACTION_ACL_DISCONNECTED);
        registerReceiver(receiver2, bluetoothFilterConn);

        IntentFilter bluetoothFilterConn1 = new IntentFilter();
        bluetoothFilterConn1.addAction(AudioManager.ACTION_SCO_AUDIO_STATE_UPDATED);
        registerReceiver(receiver3, bluetoothFilterConn1);

        binding.bluetooth21.setText(getstateStr());

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_bluetooth2;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bluetooth21:
                Toast.makeText(this,getstateStr(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.bluetooth22:
                break;
            case R.id.bluetooth23:
                AudioManagerUtils.getIns().tingTong();
                binding.bluetooth21.setText(getstateStr());
                break;
            case R.id.bluetooth24:
                AudioManagerUtils.getIns().handFree();
                binding.bluetooth21.setText(getstateStr());
                break;

        }
    }

    private String getstateStr() {
        return "";
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bluetoothAdapter.closeProfileProxy(BluetoothProfile.HEADSET,bluetoothHeadset);
    }

    private BluetoothProfile.ServiceListener profileListener = new BluetoothProfile.ServiceListener() {
        public void onServiceConnected(int profile, BluetoothProfile proxy) {
            if (profile == BluetoothProfile.HEADSET) {
                bluetoothHeadset = (BluetoothHeadset) proxy;
            }
            LogUtils.d("打印蓝牙10状态1=");
        }
        public void onServiceDisconnected(int profile) {
            if (profile == BluetoothProfile.HEADSET) {
                bluetoothHeadset = null;
            }
            //蓝牙关闭可收到
            LogUtils.d("打印蓝牙10状态2=");
        }
    };

    BroadcastReceiver receiver1=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            String deviceName = device.getName();
            String deviceHardwareAddress = device.getAddress();
            LogUtils.d("打印蓝牙0状态1=" + deviceName+"---"+deviceHardwareAddress);
        }
    };

    BroadcastReceiver receiver2=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            String deviceName = device.getName();
            String deviceHardwareAddress = device.getAddress();
            LogUtils.d("打印蓝牙状态1=" + deviceName+"---"+deviceHardwareAddress);
            binding.bluetooth21.setText(getstateStr());
        }
    };

    public BluetoothDevice getConnectDevice(){
        BluetoothDevice mDevice = null;
        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();

        if (pairedDevices.size() > 0) {
            // There are paired devices. Get the name and address of each paired device.
            for (BluetoothDevice device : pairedDevices) {
                if (bluetoothHeadset!=null&&bluetoothHeadset.getConnectionState(device)==BluetoothProfile.STATE_CONNECTING){
                    mDevice=device;
                }
            }
        }
        return mDevice;
    }

    BroadcastReceiver receiver3=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            LogUtils.d("打印蓝牙2状态1=" + intent.getIntExtra(AudioManager.EXTRA_SCO_AUDIO_STATE,0));
            LogUtils.d("打印蓝牙2状态2=" + intent.getIntExtra(AudioManager.EXTRA_SCO_AUDIO_PREVIOUS_STATE,0));

            Bundle extras = intent.getExtras();

            LogUtils.d("打印蓝牙2状态3=" + extras.size());
        }
    };
}
