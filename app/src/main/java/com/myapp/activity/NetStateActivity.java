package com.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Bundle;

import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.callback.NetworkCallbackImpl;
import com.myapp.databinding.ActivityNetStateBinding;

public class NetStateActivity extends BaseActivity<ActivityNetStateBinding> {
    NetworkCallbackImpl callback;

    //网络连接改变广播
    public static final String ANDROID_NET_CHANGE_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";

    @Override
    protected void initView() {
        NetworkRequest request=new NetworkRequest.Builder().build();
        callback = new NetworkCallbackImpl();
        ConnectivityManager cn= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        cn.registerNetworkCallback(request,callback);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_net_state;
    }


}
