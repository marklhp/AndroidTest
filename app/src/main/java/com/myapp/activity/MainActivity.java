package com.myapp.activity;

import android.Manifest;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.myapp.App;
import com.myapp.R;
import com.myapp.activity.fragment.FragmentActivity;
import com.myapp.callback.IRequestPermission;
import com.myapp.compatibility.Compatibility;
import com.myapp.databinding.ActivityMainBinding;

import com.myapp.mvc_mvp_mvvm.mvc.MVCActivity;
import com.myapp.mvc_mvp_mvvm.ordinary.OrdinaryActivity;
import com.myapp.receiver.KeepAliveReceiver;
import com.myapp.service.ServiceActivity;
import com.myapp.utils.DeviceUtils;
import com.myapp.utils.DivideUtils;
import com.myapp.utils.LogUtils;
import com.myapp.utils.PermissionUtil;
import com.myapp.utils.SDCardUtils;
import com.myapp.utils.WifiManage;

import java.util.HashMap;
import java.util.List;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableInt;

import bean.WifiInfo;
import io.reactivex.functions.Consumer;

public class MainActivity extends Activity implements View.OnClickListener {
    ActivityMainBinding binding;
    Thread thread;
    int num=0;
    private IntentFilter mKeepAliveIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setClick(this);
        ObservableInt observableInt = new ObservableInt();
        observableInt.set(R.mipmap.ic_launcher);
        binding.setSrc(observableInt);
        initData();

    }

    private void initData() {
        DeviceUtils.getIns().blueTooth(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                LogUtils.d("打印连接数量"+integer);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.liang_ping2:
                Intent newIntent = new Intent(App.context, KeepAliveReceiver.class);
                PendingIntent keepAlivePendingIntent = PendingIntent.getBroadcast(App.context, 0, newIntent, PendingIntent.FLAG_ONE_SHOT);

                AlarmManager alarmManager = ((AlarmManager) App.context.getSystemService(Context.ALARM_SERVICE));
                Compatibility.scheduleAlarm(alarmManager, AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + 1000, keepAlivePendingIntent);
                break;
            case R.id.liang_ping:
                mKeepAliveIntentFilter = new IntentFilter(Intent.ACTION_SCREEN_ON);
                mKeepAliveIntentFilter.addAction(Intent.ACTION_SCREEN_OFF);
                registerReceiver(new KeepAliveReceiver(),mKeepAliveIntentFilter);
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
                        Toast.makeText(App.context,"网络是否可以用"+aBoolean,Toast.LENGTH_SHORT).show();
                    }
                });
                PermissionUtil.reqPermission(this, new IRequestPermission() {
                    @Override
                    public void accept() {
                        thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                while (true){
                                    SystemClock.sleep(500);
                                    SDCardUtils.saveLogInfo2File(System.currentTimeMillis()+"",num+"");
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
                LogUtils.d("打印网络类型"+DeviceUtils.connectTypeIsWifi());
                break;
                case R.id.flow_id:
                skip(TrafficStatsActivity.class);
                    try {
                        List<WifiInfo> read = WifiManage.Read();
                        for (int i = 0; i < read.size(); i++) {
                            LogUtils.d("打印Wi-Fi信息"+read.get(i).toString());
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

            case R.id.phonenumber:
                skip(PhoneNumberActivity.class);
                break;
            case R.id.linphone:
                skip(LinphoneActivity.class);
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
            case R.id.local_scan:
                skip(LocalScanActivity.class);
                break;
            case R.id.zxing_scan_listenee:
                skip(ZxingScanActivity.class);
                break;
            case R.id.scan_listenee:
                skip(ServiceActivity.class);
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
            case R.id.scrollto_scrollby:

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
