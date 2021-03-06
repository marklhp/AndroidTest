package com.myapp.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
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
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.myapp.App;

import java.util.List;
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
        if (mAudioManager == null) {
            mAudioManager = ((AudioManager) App.context.getSystemService(Context.AUDIO_SERVICE));
            mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        }
    }

    public static DeviceUtils getIns() {
        if (deviceUtils == null) {
            synchronized (DeviceUtils.class) {
                deviceUtils = new DeviceUtils();
            }
        }
        return deviceUtils;
    }


    public static boolean isMiui() {
        String brand = Build.BRAND;
        Log.d("系统定制厂商", brand);
        return "Xiaomi".equalsIgnoreCase(brand) || "miui".equalsIgnoreCase(brand);
    }

    public static boolean isFlyme() {
        String brand = Build.BRAND;
        Log.d("系统定制厂商", brand);
        return "meizu".equalsIgnoreCase(brand) || "flyme".equalsIgnoreCase(brand);
    }

    public static int connectTypeIsWifi() {
        final ConnectivityManager connectivityManager = (ConnectivityManager) App.context.
                getSystemService(Context.CONNECTIVITY_SERVICE);
        LogUtils.d("网络信息" + connectivityManager.getActiveNetworkInfo().toString());
        return 0;


    }

    @SuppressLint("CheckResult")
    public void blueTooth(Consumer<Integer> callBack) {
        final int[] num = {0};
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                if (mBluetoothAdapter.getProfileConnectionState(BluetoothProfile.HEADSET)
                        != BluetoothProfile.STATE_DISCONNECTED) {

                    Set<BluetoothDevice> bondedDevices = mBluetoothAdapter.getBondedDevices();//返回一组表示已配对设备
                    if (bondedDevices != null) for (BluetoothDevice bondedDevice : bondedDevices) {
                        if (bondedDevice.getBondState() == BOND_BONDED && !mAudioManager.isBluetoothScoOn()) {
                            num[0]++;
                            LogUtils.d("打印连接信息" + bondedDevice.getName());
                        }
                    }
                } else {

                }
                emitter.onNext(num[0]);

            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(callBack);
    }


    /**
     * 判断网络是否可用 这里沿用沿用pc机 ping命令，判断，原因是android原生处理不准确
     * https://blog.csdn.net/tangguotupaopao/article/details/73136516
     *
     * @return
     */
    @SuppressLint("CheckResult")
    public static void connectIsAvailable(Consumer<Boolean> consumer) {
        Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> emitter) throws Exception {
                Runtime runtime = Runtime.getRuntime();
                Process p = runtime.exec("ping -c 3 www.baidu.com");
                int ret = p.waitFor();
                emitter.onNext(ret == 0);
                runtime = null;
                p.destroy();
                p = null;
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer);

    }

    /**
     * 判断Google服务是否可用
     */
//    public void checkisSupportGoogleServices() {
//        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
//        //是否支持Google服务
//        int resultCode = googleApiAvailability.isGooglePlayServicesAvailable(getMyContext());
//        if (resultCode == ConnectionResult.SUCCESS) {
//            GoogleApiClient mGoogleApiClient = new GoogleApiClient.Builder(getMyContext())
//                    .addApi(Fitness.HISTORY_API)
//                    .addScope(new Scope(Scopes.FITNESS_ACTIVITY_READ_WRITE))
//                    .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
//                        @Override
//                        public void onConnected(@Nullable Bundle arg0) {
//                            LogUtils.d("判断google服务"+arg0);
//                        }
//
//                        @Override
//                        public void onConnectionSuspended(int arg0) {
//                        }
//
//                    })
//                    .addOnConnectionFailedListener(
//                            new GoogleApiClient.OnConnectionFailedListener() {
//                                @Override
//                                public void onConnectionFailed(@NonNull ConnectionResult arg0) {
//                                    LogUtils.d("判断google服务addOnConnectionFailedListener"+arg0.getErrorMessage());
//                                }
//                            }).build();
//            mGoogleApiClient.connect();
//        } else {
//            LogUtils.d("判断google服务===="+false);
//        }
//    }


    private Context getMyContext() {
        return App.context;
    }

    /** 判断应用是否在运行
* @param
* @return
        */
    public static boolean isRun(String packageName){
        ActivityManager am = (ActivityManager)App.context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningTaskInfo> list = am.getRunningTasks(100);
        boolean isAppRunning = false;
        //100表示取的最大的任务数，info.topActivity表示当前正在运行的Activity，info.baseActivity表系统后台有此进程在运行
        for (ActivityManager.RunningTaskInfo info : list) {
            if (info.topActivity.getPackageName().equals(packageName) || info.baseActivity.getPackageName().equals(packageName)) {
                isAppRunning = true;
                Log.i("ActivityService isRun()",info.topActivity.getPackageName() + " info.baseActivity.getPackageName()="+info.baseActivity.getPackageName());
                break;
            }
        }
        Log.i("ActivityService isRun()", "com.ad 程序  ...isAppRunning......"+isAppRunning);
        return isAppRunning;
    }



    /**
     * 判断应用是否已经启动
     *
     * @param context   上下文对象
     * @param packageName 要判断应用的包名
     * @return boolean
     */
    public static boolean isAppAlive(Context context, String packageName) {
        ActivityManager activityManager =
                (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> processInfos
                = activityManager.getRunningAppProcesses();
        for (int i = 0; i < processInfos.size(); i++) {
            if (processInfos.get(i).processName.equals(packageName)) {
                return true;
            }
        }

        return false;
    }
}