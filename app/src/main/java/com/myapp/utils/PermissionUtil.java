package com.myapp.utils;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;

import com.myapp.App;
import com.myapp.callback.IRequestPermission;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.functions.Consumer;

/**
 * Created by lihaipeng on 2018/4/25.
 */
public class PermissionUtil {

    //请求权限
    @SuppressLint("CheckResult")
    public static void reqPermission(Activity activity,final IRequestPermission callBack, String... permissons) {
        try {
            RxPermissions rxPermission = new RxPermissions(activity);
            rxPermission.requestEach(permissons)
                    .subscribe(new Consumer<Permission>() {
                        @Override
                        public void accept(Permission permission) throws Exception {
                            if (permission.granted) {
                                // 用户已经同意该权限
                                callBack.accept();
                            } else if (permission.shouldShowRequestPermissionRationale) {
                                // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框
                                Log.d(activity.getLocalClassName(), permission.name + " is denied. More info should be provided.");

                            } else {
                                // 用户拒绝了该权限，并且选中『不再询问』
                                Log.d(activity.getLocalClassName(), permission.name + " is denied.");
                            }
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            Log.e(activity.getLocalClassName(), "",throwable);
                        }
                    });
        } catch (Exception e) {
            Log.e("","",e);
        }
    }
}