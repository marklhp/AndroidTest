package com.myapp.activity.jetpack;

import android.os.SystemClock;

import com.myapp.model.UserBean;
import com.myapp.mvc_mvp_mvvm.call_back.Callback;
import com.myapp.utils.httputil.HttpCallBack;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class JetpackModel {

    private static MutableLiveData<UserBean> user;

    public static LiveData<UserBean> getUser(){
        if (user==null){
            user=new MutableLiveData<>();
        }
        loadData();
        return user;
    }

    private static void loadData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                UserBean userBean=new UserBean("李与"+System.currentTimeMillis(),"2");
                user.postValue(userBean);
            }
        }).start();
    }
}
