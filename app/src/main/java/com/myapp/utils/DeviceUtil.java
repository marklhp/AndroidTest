package com.myapp.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.myapp.App;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DeviceUtil {
    private static Context getContext() {
        return App.context;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(float dpValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 获取机器mac值
     */
    public static String getMac() {
        String mac_s = "";
        StringBuilder buf = new StringBuilder();
        try {
            byte[] mac;
            NetworkInterface ne = NetworkInterface.getByInetAddress(InetAddress.getByName(getIP()));
            mac = ne.getHardwareAddress();
            for (byte b : mac) {
                buf.append(String.format("%02X:", b));
            }
            if (buf.length() > 0) {
                buf.deleteCharAt(buf.length() - 1);
            }
            mac_s = buf.toString();
        } catch (Exception e) {
            LogUtils.e(e);
        }
        return mac_s;
    }

    /**
     * 获取手机厂商
     */
    public static String getFactory() {
        return Build.MANUFACTURER;
    }

    /**
     * 获取MODEL
     */
    public static String getModel() {
        return Build.MODEL;
    }

    /**
     * 获取版本号
     */
    public static String getVersionCode() {
        try {
            PackageInfo pi = getContext().getPackageManager().getPackageInfo(
                    getContext().getPackageName(), 0);
            return String.valueOf(pi.versionCode);
        } catch (NameNotFoundException e) {
            LogUtils.e(e);
            return "";
        }
    }

    /**
     * 获取版本构建号
     */
    public static int getVersionNumber() {
        try {
            PackageInfo pi = getContext().getPackageManager().getPackageInfo(
                    getContext().getPackageName(), 0);
            return pi.versionCode;
        } catch (NameNotFoundException e) {
            LogUtils.e(e);
            return 0;
        }
    }

    /**
     * 获取版本号
     */
    public static String getVersionName() {
        try {
            PackageInfo pi = getContext().getPackageManager().getPackageInfo(
                    getContext().getPackageName(), 0);
            return pi.versionName;
        } catch (NameNotFoundException e) {
            LogUtils.e(e);
            return "";
        }
    }

    /**
     * 获取包名
     */
    public static String getPackageName(){
        String tempName="";
        try {
            tempName=getContext().getPackageName();
        }catch (Exception e){
            e.printStackTrace();
        }
        return tempName;
    }

    /**
     * 获取屏幕宽高
     */
    public static int getWidth() {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    /**
     * 获取屏幕宽高
     */
    public static int getHeight() {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        return displayMetrics.heightPixels;
    }

    public static String getMobileName() {
        return Build.DEVICE;
    }

    public static String getMobileInfo() {
        return "生产厂商: " + Build.MANUFACTURER + ", 手机型号: " + Build.MODEL + ", 版本号: " + Build.VERSION.RELEASE
                + ", SDK版本: " + Build.VERSION.SDK_INT + ", 主板: " + Build.BOARD + ", CPU: " + Build.CPU_ABI + ", 设备: " + Build.DEVICE;
    }

    //弹出键盘
    public static void turnOnKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(getContext().INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.RESULT_SHOWN);
    }

    public static void turnOffKeyboard(View view) {
        if (view == null) return;
        view.clearFocus();
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0); //强制隐藏键盘
    }

    public static boolean connectTypeIsWifi() {
        final ConnectivityManager connectivityManager = (ConnectivityManager) getContext().
                getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        //是否有网络并且已经连接
        return (networkInfo != null && networkInfo.isConnectedOrConnecting());


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

    public static String getIP() {
        NetworkInfo info = ((ConnectivityManager) getContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            // 3/4g网络
            if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
                try {
                    for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                        NetworkInterface intf = en.nextElement();
                        for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                            InetAddress inetAddress = enumIpAddr.nextElement();
                            if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                                return inetAddress.getHostAddress();
                            }
                        }
                    }
                } catch (SocketException e) {
                    LogUtils.e(e);
                }
            } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {
                //  wifi网络
                WifiManager wifiManager = (WifiManager) getContext().getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                String ipAddress = intIP2StringIP(wifiInfo.getIpAddress());
                return ipAddress;
            } else if (info.getType() == ConnectivityManager.TYPE_ETHERNET) {
                // 有限网络
                return getLocalIp();
            }
        }
        return null;
    }

    private static String intIP2StringIP(int ip) {
        return (ip & 0xFF) + "." +
                ((ip >> 8) & 0xFF) + "." +
                ((ip >> 16) & 0xFF) + "." +
                (ip >> 24 & 0xFF);
    }

    // 获取有限网IP
    private static String getLocalIp() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface
                    .getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf
                        .getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()
                            && inetAddress instanceof Inet4Address) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException ex) {
            LogUtils.e(ex);
        }
        return "0.0.0.0";
    }

    public static boolean isMiui() {
        String brand = Build.BRAND;//"系统定制厂商"
        return "Xiaomi".equalsIgnoreCase(brand) || "miui".equalsIgnoreCase(brand);
    }

    public static boolean isFlyme() {
        String brand = Build.BRAND;//"系统定制厂商"
        return "meizu".equalsIgnoreCase(brand) || "flyme".equalsIgnoreCase(brand);
    }




    /**
     * 获取手机型号
     *
     * @return  手机型号
     */
    public static String getSystemModel() {

        return android.os.Build.MODEL;
    }
    /**
     * 获取当前手机系统版本号
     *
     * @return  系统版本号
     */
    public static String getSystemVersion() {

        return android.os.Build.VERSION.RELEASE;
    }


    //判断当前应用是否是debug状态
    public static boolean isApkInDebug() {
        try {
            ApplicationInfo info = App.context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            return false;
        }
    }
}