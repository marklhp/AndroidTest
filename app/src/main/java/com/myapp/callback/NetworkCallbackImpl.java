package com.myapp.callback;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;

import com.myapp.utils.LogUtils;

public class NetworkCallbackImpl extends ConnectivityManager.NetworkCallback {
    @Override
    public void onAvailable(Network network) {
        super.onAvailable(network);
        LogUtils.d("连接了");
    }

    @Override
    public void onLost(Network network) {
        super.onLost(network);
        LogUtils.d("1连接了"+network.toString());
    }


}
