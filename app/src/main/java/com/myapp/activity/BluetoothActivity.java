package com.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;

import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityBluetoothBinding;
import com.myapp.utils.AudioManagerUtils;
import com.myapp.utils.LogUtils;

import io.reactivex.functions.Consumer;

public class BluetoothActivity extends BaseActivity<ActivityBluetoothBinding> implements View.OnClickListener {

    @Override
    protected void initView() {
        binding.setClick(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_bluetooth;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bluetooth1:
                //蓝牙链接广播
                IntentFilter bluetoothFilterConn0 = new IntentFilter();
                bluetoothFilterConn0.addAction(BluetoothDevice.ACTION_ACL_CONNECTED);
                registerReceiver(receiver1, bluetoothFilterConn0);

                IntentFilter bluetoothFilterConn = new IntentFilter();
                bluetoothFilterConn.addAction(BluetoothDevice.ACTION_ACL_DISCONNECTED);
                registerReceiver(receiver2, bluetoothFilterConn);

                IntentFilter bluetoothFilterConn1 = new IntentFilter();
                bluetoothFilterConn1.addAction(AudioManager.ACTION_SCO_AUDIO_STATE_UPDATED);
                registerReceiver(receiver3, bluetoothFilterConn1);

                IntentFilter bluetoothFilterConn4 = new IntentFilter();
                bluetoothFilterConn4.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
                registerReceiver(receiver4, bluetoothFilterConn4);

                IntentFilter bluetoothFilterConn5 = new IntentFilter();
                bluetoothFilterConn5.addAction(BluetoothDevice.ACTION_PAIRING_REQUEST);
                registerReceiver(receiver5, bluetoothFilterConn5);
                break;
            case R.id.bluetooth2:
                AudioManagerUtils.getIns().getBluetooth(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {

                    }
                });

                break;
            case R.id.bluetooth3:
                LogUtils.d("打印蓝牙连接"+"-==-"+AudioManagerUtils.getIns().isBluetoothConnect());
                break;
            case R.id.bluetooth4:

                break;
            case R.id.bluetooth5:

                break;
            case R.id.bluetooth6:
                break;
            case R.id.bluetooth7:
                break;
            case R.id.bluetooth8:
                break;

        }
    }

    BroadcastReceiver receiver1=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            LogUtils.d("打印蓝牙0状态1=" + intent.getIntExtra(BluetoothDevice.EXTRA_DEVICE,0));
        }
    };

    BroadcastReceiver receiver2=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            LogUtils.d("打印蓝牙状态1=" + intent.getIntExtra(BluetoothDevice.EXTRA_DEVICE,0));
        }
    };
    BroadcastReceiver receiver3=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            LogUtils.d("打印蓝牙2状态1=" + intent.getIntExtra(AudioManager.EXTRA_SCO_AUDIO_STATE,0));
            LogUtils.d("打印蓝牙2状态2=" + intent.getIntExtra(AudioManager.EXTRA_SCO_AUDIO_PREVIOUS_STATE,0));

            Bundle extras = intent.getExtras();

                        LogUtils.d("打印蓝牙2状态3=" + extras.size());
        }
    };
    BroadcastReceiver receiver4=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            LogUtils.d("打印蓝牙4状态1=" + intent.getIntExtra(BluetoothDevice.EXTRA_DEVICE,0));
            LogUtils.d("打印蓝牙4状态2=" + intent.getIntExtra(BluetoothDevice.EXTRA_BOND_STATE,0));
            LogUtils.d("打印蓝牙4状态3=" + intent.getIntExtra(BluetoothDevice.EXTRA_PREVIOUS_BOND_STATE,0));
        }
    };
    BroadcastReceiver receiver5=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            LogUtils.d("打印蓝牙5状态1=" + intent.getIntExtra(BluetoothDevice.EXTRA_DEVICE,0));
            LogUtils.d("打印蓝牙5状态2=" + intent.getIntExtra(BluetoothDevice.EXTRA_BOND_STATE,0));
            LogUtils.d("打印蓝牙5状态3=" + intent.getIntExtra(BluetoothDevice.EXTRA_PREVIOUS_BOND_STATE,0));
        }
    };
}
