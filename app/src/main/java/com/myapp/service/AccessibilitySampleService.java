package com.myapp.service;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import com.myapp.accessibilityutils.utils.AccessibilityLog;

import org.linphone.mediastream.Log;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
//辅助功能服务类
public class AccessibilitySampleService extends AccessibilityService {
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        initevent(event);
    }



    @Override
    public void onInterrupt() {

    }
    @SuppressLint("CheckResult")
    private void initevent(AccessibilityEvent event) {
        Log.d("辅助功能",event.toString());
        Observable.create(new ObservableOnSubscribe<AccessibilityEvent>() {
            @Override
            public void subscribe(ObservableEmitter<AccessibilityEvent> emitter) throws Exception {

                emitter.onNext(syncRun(event));
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AccessibilityEvent>() {
                    @Override
                    public void accept(AccessibilityEvent accessibilityEvent) throws Exception {

                    }
                });
    }

    private AccessibilityEvent syncRun(AccessibilityEvent event) {
        String pkgName = event.getPackageName().toString();
        int eventType = event.getEventType();
        AccessibilityOperator.getInstance().updateEvent(this, event);
//        try {
//            Thread.sleep(200);
//        } catch (Exception e) {}
        AccessibilityLog.printLog("eventType: " + eventType + " pkgName: " + pkgName);
        switch (eventType) {
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
                break;
        }
        return event;
    }

}
