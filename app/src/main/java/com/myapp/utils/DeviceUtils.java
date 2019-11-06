package com.myapp.utils;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;

import com.myapp.App;

import java.util.Set;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static android.bluetooth.BluetoothDevice.BOND_BONDED;

public class DeviceUtils {
    private BluetoothAdapter mBluetoothAdapter;
    private AudioManager mAudioManager = null;
    private static DeviceUtils deviceUtils;

    public DeviceUtils() {
        if (mAudioManager==null){
            mAudioManager = ((AudioManager) App.context.getSystemService(Context.AUDIO_SERVICE));
            mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        }
    }
    public static DeviceUtils getIns(){
        if (deviceUtils==null){
            synchronized (DeviceUtils.class){
                deviceUtils=new DeviceUtils();
            }
        }
        return deviceUtils;
    }


    public static boolean isMiui(){
        String brand=Build.BRAND;
        Log.d("系统定制厂商",brand);
        return "Xiaomi".equalsIgnoreCase(brand)||"miui".equalsIgnoreCase(brand);
    }

    public static boolean isFlyme() {
        String brand=Build.BRAND;
        Log.d("系统定制厂商",brand);
        return "meizu".equalsIgnoreCase(brand)||"flyme".equalsIgnoreCase(brand);
    }
    public static int connectTypeIsWifi() {
        final ConnectivityManager connectivityManager = (ConnectivityManager) App.context.
                getSystemService(Context.CONNECTIVITY_SERVICE);
        LogUtils.d("网络信息"+connectivityManager.getActiveNetworkInfo().toString());
        return 0;


    }
    @SuppressLint("CheckResult")
    public  void blueTooth(Consumer<Integer> callBack){
        final int[] num = {0};
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                if (mBluetoothAdapter.getProfileConnectionState(BluetoothProfile.HEADSET)
                        != BluetoothProfile.STATE_DISCONNECTED){

                    Set<BluetoothDevice> bondedDevices = mBluetoothAdapter.getBondedDevices();//返回一组表示已配对设备
                    if (bondedDevices!=null) for (BluetoothDevice bondedDevice : bondedDevices) {
                        if(bondedDevice.getBondState()==BOND_BONDED&&!mAudioManager.isBluetoothScoOn()){
                           num[0]++;
                            LogUtils.d("打印连接信息"+bondedDevice.getName());
                        }
                    }
                }else {

                }
                emitter.onNext(num[0]);

            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(callBack);
    }
}
