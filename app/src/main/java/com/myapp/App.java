package com.myapp;

import android.app.Application;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.myapp.utils.ClipboardUtils;
import com.myapp.utils.glide.DelayedUIUtils;
import com.scwang.smartrefresh.header.WaterDropHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import androidx.annotation.NonNull;
import androidx.multidex.MultiDexApplication;

/**
 * Created by lihaipeng on 2018/5/18.
 */

public class App extends MultiDexApplication {
    public static Context context;
    public static Application application;
    public static Task<InstanceIdResult> instanceId;

    static {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout) {
                return new WaterDropHeader(context);
            }
        });
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @NonNull
            @Override
            public RefreshFooter createRefreshFooter(@NonNull Context context, @NonNull RefreshLayout layout) {
                return new ClassicsFooter(context);
            }
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        application = this;
        DelayedUIUtils.checkTime();
        instanceId = FirebaseInstanceId.getInstance().getInstanceId();
        instanceId.addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
            @Override
            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                Log.d("app", "打印令牌"+instanceId.getResult().getToken());
                ClipboardUtils.onClickCopy(task.getResult().getToken());
            }
        });
    }

}
