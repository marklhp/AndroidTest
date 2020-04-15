package com.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.myapp.R;
import com.myapp.base.BaseActivity;
import com.myapp.databinding.ActivitySocketBinding;
import com.myapp.utils.LogUtils;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.ssl.SSLContext;

public class SocketActivity extends BaseActivity<ActivitySocketBinding> {

    public static final String SERVICE_HOST = "mtalk.google.com";
    public static final int SERVICE_PORT = 5228;
    private Socket sslSocket;

    @Override
    protected void initView() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                InetAddress locAdd = null;
                try {
                    locAdd = InetAddress.getLocalHost();
                    InetAddress remAdd = 	InetAddress.getByName("mtalk.google.com");

                    byte[] ip= {(byte) 211,100,52,39};
                    InetAddress remAdd2 = InetAddress.getByAddress(ip);
                    LogUtils.d("本机IP= " + locAdd.getHostAddress());
                    LogUtils.d("成都传智播客IP= " + 		remAdd.getHostAddress()+"==="+remAdd.isReachable(3000));


                    Socket socket = new Socket(SERVICE_HOST, SERVICE_PORT);
                    sslSocket = SSLContext.getDefault().getSocketFactory().createSocket(socket, SERVICE_HOST, SERVICE_PORT, true);

                    LogUtils.d("是否可以送达：" + 	sslSocket.isConnected());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_socket;
    }

}
