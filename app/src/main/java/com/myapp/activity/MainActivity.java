package com.myapp.activity;

import android.Manifest;
import android.app.Activity;
import android.app.Instrumentation;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableInt;

import com.github.moduth.blockcanary.BlockCanary;
import com.myapp.App;
import com.myapp.R;
import com.myapp.activity.fragment.FragmentActivity;
import com.myapp.apt.AThread;
import com.myapp.apt.BThread;
import com.myapp.apt.IastingHolder;
import com.myapp.base.BaseActivity;
import com.myapp.callback.IRequestPermission;
import com.myapp.databinding.ActivityMainBinding;
import com.myapp.java.MyFrameCallback;
import com.myapp.mvc_mvp_mvvm.mvc.MVCActivity;
import com.myapp.mvc_mvp_mvvm.ordinary.OrdinaryActivity;
import com.myapp.proxy.ProxyUtils;
import com.myapp.receiver.KeepAliveReceiver;
import com.myapp.utils.AudioManagerUtils;
import com.myapp.utils.DeviceUtils;
import com.myapp.utils.DivideUtils;
import com.myapp.utils.LogUtils;
import com.myapp.utils.MemoryInfoUtils;
import com.myapp.utils.MessageDataAnalysisUtils;
import com.myapp.utils.PermissionUtil;
import com.myapp.utils.SDCardUtils;
import com.myapp.utils.WhiteListUtils;
import com.myapp.utils.WifiManage;
import com.myapp.vpn.ToyVpnClient;

import org.greenrobot.eventbus.EventBus;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import bean.WifiInfo;
import io.reactivex.functions.Consumer;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements View.OnClickListener {

    Thread thread;
    int num = 0;
    private IntentFilter mKeepAliveIntentFilter;


    @Override
    protected void initView() {
        binding.setClick(this);
        ObservableInt observableInt = new ObservableInt();
        observableInt.set(R.mipmap.ic_launcher);
        binding.setSrc(observableInt);
        initData();
        LogUtils.d("音频是否可以调整" + AudioManagerUtils.getIns().isVolumeFixed());
//        long t=System.currentTimeMillis();
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ceshi);
//        long t1=System.currentTimeMillis()-t;
//        long t2=System.currentTimeMillis();
//        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(),R.drawable.agyn4y44un);
//        long t3=System.currentTimeMillis()-t2;
//        LogUtils.d("打印日志" + bitmap.getByteCount()+"---"+bitmap1.getByteCount()+"--"+t1+"=="+t3);
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("aa.bb.cc");
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                LogUtils.d("===---==//"+intent.getAction()+"---"+Thread.currentThread());
            }
        },intentFilter);
    }

    @Override
    public int getLayoutId() {
        return  R.layout.activity_main;
    }


    private void initData() {

        DeviceUtils.getIns().blueTooth(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                LogUtils.d("打印连接数量" + integer);
            }
        });
        Choreographer.getInstance().postFrameCallback(new MyFrameCallback());
    }
    ArrayList<String> list=new ArrayList<>();
    Instrumentation instrumentation=new Instrumentation();
    AtomicLong atomicLong=new AtomicLong();
    AtomicLong strSize=new AtomicLong();
    String sz="2020-03-31 10:15:45.932 3948-14509/? D/SamsungAlarmManager: Cancel Alarm calling from uid:10218 pid :26234 / op:PendingIntent{51547: PendingIntentRecord{b79ed8b com.tencent.android.qqdownloader broadcastIntent}}";
    Thread enterThread;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.threadinter1:
               new Thread(new Runnable() {
                   @Override
                   public void run() {
                       AThread.get();
                   }
               }).start();
               new Thread(new Runnable() {
                   @Override
                   public void run() {
                       BThread.get();
                   }
               }).start();
                break;
            case R.id.threadinter:
                enterThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            int num=0;
                            for (int i=0;i<100;i++){
                                num++;
                                SystemClock.sleep(1000);
                                LogUtils.d("线程中断"+num+"=="+enterThread.isInterrupted());
                                if (i>8){
                                    Thread.interrupted();
                                }
                            }
                        }catch (Exception e){
                            LogUtils.d("线程"+e.getMessage());
                        }
                    }
                });
                enterThread.start();
                break;
            case R.id.dynamic_proxy:
                ProxyUtils.proxyUse();
                LogUtils.d("======"+IastingHolder.Settings.getBoolean("jjjll",false));
                IastingHolder.Settings.addBoolean("jjj==",true);
                LogUtils.d("======"+IastingHolder.Settings.getBoolean("jjj==",false));
                break;
            case R.id.startmain:
                skip(MainActivity.class);
                break;
            case R.id.sendthreadbroadcast:
                Intent broadintent=new Intent();
                broadintent.setClass(MainActivity.this,KeepAliveReceiver.class);
                sendBroadcast(broadintent,"com.eestorm.cefsdk.receiver");
                ThreadLocal threadLocal=new ThreadLocal();
                threadLocal.set("000");
                break;

            case R.id.sendmessage:
                RemoteCallbackList list=new RemoteCallbackList();
                SystemClock.sleep(10000);
                Toast.makeText(this,"----",Toast.LENGTH_LONG).show();
                break;
            case R.id.rxjava:
                skip(RxjavaActivity.class);
                break;
            case R.id.memory_info:
                MemoryInfoUtils.getMemoryInfo();
                break;
            case R.id.observer_mode:

//                RecyclerView.Adapter
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        while (true){
//                            if (list.size()>5000){
//                                strSize.set(strSize.get()-list.get(0).length());
//                                list.remove(0);
//
//                            }
//                            list.add(sz);
//                            strSize.set(strSize.get()+sz.length());
//                            atomicLong.set(atomicLong.get()+1);
//                            LogUtils.d("打印字节大小"+atomicLong.get()+"===="+strSize.get());
//                        }
//                    }
//                }).start();
                LogUtils.d("打印字节大小"+sz.length()+"===="+sz.getBytes().length);
//                ActivityManager.getMyMemoryState();
                break;

            case R.id.flexbos_2222:
                skip(FlexboxActivity.class);
                break;
            case R.id.applicationinfo:
                skip(WhiteListActivity.class);
                break;
            case R.id.dataAnalySis:
                MessageDataAnalysisUtils.dataAnalySis();
                break;
                case R.id.media_bofang:
                skip(MediaPlayerActivity.class);
                break;


            case R.id.socket:
                skip(SocketActivity.class);
                break;
            case R.id.join_whitelist:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (!WhiteListUtils.isIgnoringBatteryOptimizations()) {
                        WhiteListUtils.requestIgnoreBatteryOptimizations(this);
                    }
                }
                break;
            case R.id.jumpto_application_detail:
                try {
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    intent.setData(Uri.fromParts("package", getPackageName(), null));
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.vpn_activity2:
                skip(TestVpnActivity.class);

                break;
            case R.id.vpn_activity:
                skip(ToyVpnClient.class);
                break;
            case R.id.trace_route:
                skip(TraceActivity.class);
                break;
            case R.id.fragmenttabhost:
                skip(FragmentSwitchActivity.class);
                break;

            case R.id.file_check:
                skip(FileCheckActivity.class);
                break;
            case R.id.liang_ping:
                mKeepAliveIntentFilter = new IntentFilter(Intent.ACTION_SCREEN_ON);
                mKeepAliveIntentFilter.addAction(Intent.ACTION_SCREEN_OFF);
                registerReceiver(new KeepAliveReceiver(), mKeepAliveIntentFilter);
                break;
            case R.id.net_state:
                skip(NetStateActivity.class);
                break;

            case R.id.proximity_sensing:
                skip(MiePingActivity.class);
                break;


            case R.id.check_net:
                DeviceUtils.connectIsAvailable(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        Toast.makeText(App.context, "网络是否可以用" + aBoolean, Toast.LENGTH_SHORT).show();
                    }
                });
                PermissionUtil.reqPermission(this, new IRequestPermission() {
                    @Override
                    public void accept() {
                        thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                while (true) {
                                    SystemClock.sleep(500);
                                    SDCardUtils.saveLogInfo2File(System.currentTimeMillis() + "", num + "");
                                    num++;
                                }
                            }
                        });
                        thread.start();
                    }
                }, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                break;
            case R.id.bluetooth:
                skip(BluetoothActivity.class);
                break;
            case R.id.web_view_id:
                skip(WebActivity.class);
                break;
            case R.id.thread_id:
                skip(ThreadActivity.class);
                LogUtils.d("打印网络类型" + DeviceUtils.connectTypeIsWifi());
                break;
            case R.id.flow_id:
                skip(TrafficStatsActivity.class);
                try {
                    List<WifiInfo> read = WifiManage.Read();
                    for (int i = 0; i < read.size(); i++) {
                        LogUtils.d("打印Wi-Fi信息" + read.get(i).toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;


            case R.id.android_bg:
                skip(BgActivity.class);
                break;

            case R.id.android_hook:
                skip(AndroidHookActivity.class);
                break;

            case R.id.test_jni:
                skip(JniActivity.class);
                break;

            case R.id.test_fragment:
                skip(TestFragmentActivity.class);
                break;
            case R.id.room:
                skip(RoomActivity.class);
                break;
            case R.id.fragment:
                skip(FragmentActivity.class);
                break;
            case R.id.jet:
                skip(JetpackActivity.class);
                break;
            case R.id.accessibility:
                skip(AccessibilityServiceActivity.class);
                break;
            case R.id.mvc:
                skip(MVCActivity.class);
                break;
            case R.id.ordinary:
                skip(OrdinaryActivity.class);
                break;

            case R.id.ui_delayed:
                skip(DelayedUIActivity.class);
                break;
            case R.id.rsa:
                skip(RSAActivity.class);
                break;
            case R.id.json_gson:
                skip(JsonActivity.class);
                break;
            case R.id.zxing_scan_listenee:
                skip(ZxingScanActivity.class);
                break;
            case R.id.floating_window:
                skip(FloatingWindowActivity.class);
                break;
            case R.id.px_measure:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        SystemClock.sleep(5000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(App.context, "toast", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).start();
                break;
            case R.id.websocket:
                skip(WebSocketActivity.class);
                break;
            case R.id.image_view:
                ObservableInt observableInt = new ObservableInt();
                observableInt.set(R.drawable.error_circle);
                binding.setSrc(observableInt);
                break;

            case R.id.datepicker_timepicker:
                skip(DateTimePickerActivity.class);
                break;
            case R.id.edit_focusable:
                skip(EditActivity.class);
                break;
            case R.id.touchevent:
                skip(TouchEventActivity.class);
                break;

            case R.id.hashmap:
                HashMap<String, Integer> hashMap = new HashMap<>();
                hashMap.put("12", 33);
                Toast.makeText(this, hashMap.get("12") + "---" + hashMap.get("22"), Toast.LENGTH_SHORT).show();

                break;
            case R.id.multiple_types_recycle:
                skip(MultipleTypesRecycleActivity.class);
                break;
            case R.id.dadabinding_glide:
                long time1 = SystemClock.currentThreadTimeMillis();
                long time2 = SystemClock.currentThreadTimeMillis();
                Log.d("  打印时间", time2 - time1 + "");
                startActivity(new Intent(this, DataBinding_Glide_Activity.class));
                break;
            case R.id.smartrefreshlayout:
                startActivity(new Intent(this, RefreshLayoutActivity.class));
                break;
            case R.id.flexboxlayout_activity:
                startActivity(new Intent(this, FlexboxlayoutActivity.class));
                break;
            case R.id.constrationactivity:
                startActivity(new Intent(this, ConstrationActivity.class));
                break;
            case R.id.popupwendow:

                break;
            case R.id.coordinator:
                skip(CoordinatorActivity.class);
                break;
            case R.id.divide:
                Toast.makeText(this, "" + DivideUtils.div(4, 3, 4), Toast.LENGTH_SHORT).show();
                break;
            case R.id.spinner:
                skip(SpinnerActivity.class);
                break;
            case R.id.fragment_life:
                skip(MyFragmentActivity.class);
                break;
            case R.id.sweet_alert:
                skip(SweetActivity.class);
                break;
            case R.id.zhuanhuan:
                skip(ZhuanHuanActivity.class);
                break;
            case R.id.getcolor:
                binding.getcolor.setTextColor(Color.parseColor("#ff00ff"));
                break;
            case R.id.finger_print:
                skip(FingerActivity.class);
                break;
            case R.id.recycler_nesting_recycler:
                skip(RecyclerNestingRecyclerActivity.class);
                break;

        }
    }

    private void skip(Class clazz) {
        startActivity(new Intent(this, clazz));
    }


}
