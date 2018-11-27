package com.myapp.service;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.view.accessibility.AccessibilityEvent;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

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
        Observable.create(new ObservableOnSubscribe<AccessibilityEvent>() {
            @Override
            public void subscribe(ObservableEmitter<AccessibilityEvent> emitter) throws Exception {
                emitter.onNext(event);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AccessibilityEvent>() {
                    @Override
                    public void accept(AccessibilityEvent accessibilityEvent) throws Exception {

                    }
                });
    }
}
