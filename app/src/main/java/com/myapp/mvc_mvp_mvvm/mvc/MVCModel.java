package com.myapp.mvc_mvp_mvvm.mvc;

import android.app.Activity;

import com.myapp.mvc_mvp_mvvm.mvc.MVCActivity;
import com.myapp.mvc_mvp_mvvm.ordinary.entry.JobInfoBean;
import com.myapp.mvc_mvp_mvvm.ordinary.entry.UserInfoBean;
import com.myapp.utils.httputil.HttpCallBack;
import com.myapp.utils.httputil.HttpUtils;
import com.myapp.utils.httputil.ModelCallBack;

import java.lang.ref.WeakReference;

public class MVCModel {
    WeakReference<Activity> mActivity;

    public void getUserInfo(HttpCallBack<UserInfoBean> callBack) {
        HttpUtils.getUserInfo(callBack);
    }
    public void changeUserInfo(final Activity activity, final HttpCallBack<UserInfoBean> callBack, final HttpCallBack<JobInfoBean> callBack1) {

        HttpUtils.changeUserInfo(new HttpCallBack<UserInfoBean>() {
            @Override
            public void call(final UserInfoBean userInfoBean) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.call(userInfoBean);
                    }
                });
            }
        }, new HttpCallBack<JobInfoBean>() {
            @Override
            public void call(final JobInfoBean jobInfoBean) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack1.call(jobInfoBean);
                    }
                });
            }
        });
    }

    public void forger(ModelCallBack<String> callBack) {
        int newAge= (int)Math.random()*100;
        newAge=newAge-(int)Math.random()*10;
        newAge=newAge-(int)Math.random()*10;
        newAge=newAge+(int)Math.random()*10;
        newAge=newAge-(int)Math.random()*10;
        newAge=newAge+(int)Math.random()*10;
        newAge=newAge-(int)Math.random()*10;
        newAge=newAge-(int)Math.random()*10;
        newAge=newAge+(int)Math.random()*10;
        newAge=newAge-(int)Math.random()*10;
        newAge=newAge-(int)Math.random()*10;
        newAge=newAge+(int)Math.random()*10;
        newAge=newAge-(int)Math.random()*10;
        newAge=newAge+(int)Math.random()*10;
        newAge=newAge-(int)Math.random()*10;
        callBack.call(newAge+"");

    }
}
