package com.myapp.android_hook;

import android.content.Context;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HookSetOnClickListenerHelper {


    public static void hook(Context context, final View v){
        try {
            Method method=View.class.getDeclaredMethod("getListenerInfo");
            method.setAccessible(true);
            Object mListenerInfo=method.invoke(v);


            Class<?> listenerInfoClz=Class.forName("android.view.View$ListenerInfo");
            Field field=listenerInfoClz.getDeclaredField("mOnClickListener");
            final View.OnClickListener onClickListenerInstance= (View.OnClickListener) field.get(mListenerInfo);

            Object proxyOnClickListener =Proxy.newProxyInstance(context.getClass().getClassLoader(), new Class[]{View.OnClickListener.class}, new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    Log.d("HookSetOnClickListener", "点击事件被hook到了");//加入自己的逻辑
                    return method.invoke(onClickListenerInstance, args);//执行被代理的对象的逻辑
                }
            });
            field.set(mListenerInfo,proxyOnClickListener);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    static class ProxyOnClickListener implements View.OnClickListener{
        View.OnClickListener oriLis;

        public ProxyOnClickListener(View.OnClickListener oriLis) {
            this.oriLis = oriLis;
        }
        @Override
        public void onClick(View v) {
            Log.d("HookSetOnClickListener1", "点击事件被hook到了");
            if (oriLis != null) {
                oriLis.onClick(v);
            }
        }
    }

}
