package com.myapp.mvc_mvp_mvvm.mvp;

import android.app.Activity;

import com.myapp.mvc_mvp_mvvm.ordinary.entry.JobInfoBean;
import com.myapp.mvc_mvp_mvvm.ordinary.entry.UserInfoBean;
import com.myapp.utils.httputil.HttpCallBack;
import com.myapp.utils.httputil.HttpCallBack2;
import com.myapp.utils.httputil.HttpUtils;
import com.myapp.utils.httputil.ModelCallBack;

public class MvpModel {
    public void getUserInfo(HttpCallBack<UserInfoBean> callBack) {
        HttpUtils.getUserInfo(callBack);
    }

    public void changeUserInfo( HttpCallBack2<UserInfoBean,JobInfoBean> callBack) {
        HttpUtils.changeUserInfo2(callBack);
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
