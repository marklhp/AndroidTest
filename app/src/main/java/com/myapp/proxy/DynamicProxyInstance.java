package com.myapp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyInstance implements InvocationHandler {

    // 动态代理，这里不限制具体使用的接口是什么，而是使用Object表示真实对象
    private Object realInstance;

    public void init(Object realInstance) {
        this.realInstance = realInstance;
    }

    public Object getPrxyInstance(){
        Object o = Proxy.newProxyInstance(realInstance.getClass().getClassLoader(),realInstance.getClass().getInterfaces(), this);
        return o;
    }

    /**
     * 售前
     */
    private void doBefore() {
        System.out.println("售前");
    }

    /**
     * 售后
     */
    private void doAfter() {
        System.out.println("售后");
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        Object res=method.invoke(realInstance,args);
        doAfter();
        return res;
    }
}
