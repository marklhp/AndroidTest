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

import com.myapp.App;
import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivityBluetoothBinding;
import com.myapp.utils.AudioManagerUtils;
import com.myapp.utils.LogUtils;

import java.util.List;
import java.util.Set;

import io.reactivex.functions.Consumer;

import static android.bluetooth.BluetoothAdapter.ACTION_STATE_CHANGED;
import static android.bluetooth.BluetoothAdapter.EXTRA_PREVIOUS_STATE;
import static android.bluetooth.BluetoothAdapter.EXTRA_STATE;

public class BluetoothActivity extends BaseActivity<ActivityBluetoothBinding> implements View.OnClickListener {
    BluetoothHeadset bluetoothHeadset;
    // Get the default adapter
    BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    @Override
    protected void initView() {
        binding.setClick(this);
        IntentFilter bluetoothFilterConn0 = new IntentFilter();
        bluetoothFilterConn0.addAction(BluetoothDevice.ACTION_ACL_CONNECTED);
        registerReceiver(receiver1, bluetoothFilterConn0);

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

                break;
            case R.id.bluetooth2:
//                AudioManagerUtils.getIns().getBluetooth(new Consumer<Boolean>() {
//                    @Override
//                    public void accept(Boolean aBoolean) throws Exception {
//
//                    }
//                });

                break;
            case R.id.bluetooth3:
                LogUtils.d("打印蓝牙连接"+"-==-"+AudioManagerUtils.getIns().isBluetoothConnect());
                break;
            case R.id.bluetooth4:
                IntentFilter bluetoothFilterConn = new IntentFilter();
                bluetoothFilterConn.addAction(BluetoothDevice.ACTION_ACL_DISCONNECTED);
                registerReceiver(receiver2, bluetoothFilterConn);
                break;
            case R.id.bluetooth5:
                IntentFilter bluetoothFilterConn1 = new IntentFilter();
                bluetoothFilterConn1.addAction(AudioManager.ACTION_SCO_AUDIO_STATE_UPDATED);
                registerReceiver(receiver3, bluetoothFilterConn1);
                break;
            case R.id.bluetooth6:
                IntentFilter bluetoothFilterConn4 = new IntentFilter();
                bluetoothFilterConn4.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
                registerReceiver(receiver4, bluetoothFilterConn4);
                break;
            case R.id.bluetooth7:
                IntentFilter bluetoothFilterConn5 = new IntentFilter();
                bluetoothFilterConn5.addAction(BluetoothDevice.ACTION_PAIRING_REQUEST);
                registerReceiver(receiver5, bluetoothFilterConn5);
                break;
            case R.id.bluetooth8:
//                发现设备
                // Register for broadcasts when a device is discovered.
                IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
                registerReceiver(receiver7, filter);



                break;
            case R.id.bluetooth9:
                //启用可检测性
                Intent discoverableIntent =
                        new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
                startActivity(discoverableIntent);

                break;
            case R.id.bluetooth10:
                LogUtils.d("打印蓝牙状态"+bluetoothAdapter.isEnabled());
                if (!bluetoothAdapter.isEnabled()) {
                    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(enableBtIntent, 1);
                }
                break;
            case R.id.bluetooth11:
                //判断蓝牙是否打开
                IntentFilter bluetoothFilterConn6 = new IntentFilter();
                bluetoothFilterConn6.addAction(ACTION_STATE_CHANGED);
                registerReceiver(receiver6, bluetoothFilterConn6);
                break;
            case R.id.bluetooth12:
                //查询已配对设备
                Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();

                if (pairedDevices.size() > 0) {
                    // There are paired devices. Get the name and address of each paired device.
                    for (BluetoothDevice device : pairedDevices) {
                        String deviceName = device.getName();
                        String deviceHardwareAddress = device.getAddress(); // MAC address

                        LogUtils.d("打印蓝牙7=" + deviceName+"==="+deviceHardwareAddress+"==="+device.getBondState()+"--"+device.describeContents());
                    }
                }
                break;
            case R.id.bluetooth13:

                LogUtils.d("打印蓝牙9=" +bluetoothAdapter.getName());
                break;
            case R.id.bluetooth14:
                // Establish connection to the proxy.
                bluetoothAdapter.getProfileProxy(this, profileListener, BluetoothProfile.HEADSET);
                break;
            case R.id.bluetooth15:
                // Close proxy connection after use.
                bluetoothAdapter.closeProfileProxy(BluetoothProfile.HEADSET,bluetoothHeadset);

                break;
            case R.id.bluetooth16:

                break;

        }
    }

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
            LogUtils.d("打印蓝牙状态1=" + intent.getStringExtra(BluetoothDevice.EXTRA_DEVICE));
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

    BroadcastReceiver receiver6=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            LogUtils.d("打印蓝牙6状态1=" + intent.getIntExtra( EXTRA_STATE,0));
            LogUtils.d("打印蓝牙6状态2=" + intent.getIntExtra( EXTRA_PREVIOUS_STATE,0));
            LogUtils.d("打印蓝牙6状态3=" + intent.getIntExtra(BluetoothDevice.EXTRA_PREVIOUS_BOND_STATE,0));
        }
    };
    BroadcastReceiver receiver7=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                // Discovery has found a device. Get the BluetoothDevice
                // object and its info from the Intent.
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                String deviceName = device.getName();
                String deviceHardwareAddress = device.getAddress(); // MAC address
                LogUtils.d("打印蓝牙8状态1=" + deviceName+"---"+deviceHardwareAddress);
            }

        }
    };


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver1);
        unregisterReceiver(receiver2);
        unregisterReceiver(receiver4);
        unregisterReceiver(receiver5);
        unregisterReceiver(receiver6);
        unregisterReceiver(receiver7);
    }

    private BluetoothProfile.ServiceListener profileListener = new BluetoothProfile.ServiceListener() {
        public void onServiceConnected(int profile, BluetoothProfile proxy) {
            if (profile == BluetoothProfile.HEADSET) {
                bluetoothHeadset = (BluetoothHeadset) proxy;
            }
            Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();

            if (pairedDevices.size() > 0) {
                // There are paired devices. Get the name and address of each paired device.
                for (BluetoothDevice device : pairedDevices) {
                    String deviceName = device.getName();
                    String deviceHardwareAddress = device.getAddress(); // MAC address

                    LogUtils.d("打印蓝牙10=" + deviceName+"==="+deviceHardwareAddress+"==="+device.getBondState()+"--"+proxy.getConnectionState(device));
                }
            }
            LogUtils.d("打印蓝牙10=1*"+"--"+pairedDevices.size() );
        }
        public void onServiceDisconnected(int profile) {
            if (profile == BluetoothProfile.HEADSET) {
                bluetoothHeadset = null;
            }
            //蓝牙关闭可收到
            LogUtils.d("打印蓝牙10状态2=");
        }
    };
}
