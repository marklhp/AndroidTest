package com.myapp.utils;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.myapp.App;
import com.myapp.linphone.LinphoneManager;
import com.myapp.linphone.SipUtils;

import java.util.concurrent.atomic.AtomicLong;

public class AutoDialNumber {


    public static AtomicLong atomicLong=new AtomicLong();
    @SuppressLint("HandlerLeak")
    public static Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    atomicLong.set(atomicLong.get()+1);
                    Toast.makeText(App.context,atomicLong.get()+"",Toast.LENGTH_SHORT).show();
                    SipUtils.call();
                    handler.sendEmptyMessageDelayed(2,25000);
                    break;
                case 2:
                    LinphoneManager.getInstance().hangUp();
                    handler.sendEmptyMessageDelayed(1,6000);
                    break;
            }
        }
    };

    public static void autoDial(){
        handler.sendEmptyMessageDelayed(1,2);
    }
}
