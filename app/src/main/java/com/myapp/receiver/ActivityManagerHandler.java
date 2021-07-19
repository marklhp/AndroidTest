package com.myapp.receiver;

import android.content.Intent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ActivityManagerHandler implements InvocationHandler {
    private Object mActivityManager;

    public ActivityManagerHandler(Object activityManager) {
        mActivityManager = activityManager;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("broadcastIntent")){
            for(Object o : args){
                if(o == null){
                    continue;
                }
                if(o instanceof Intent){
                    Intent intent = (Intent)o;
//                    int includeBackground = Reflect.on(Intent.class).field("FLAG_RECEIVER_INCLUDE_BACKGROUND").get();
//                    intent.setFlags(intent.getFlags()| includeBackground);
                }
            }
        }
        return method.invoke(mActivityManager,args);
    }
}
