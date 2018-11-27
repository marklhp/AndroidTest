package com.myapp.utils.httputil;

public interface HttpCallBack2<T,C> {
    void call(T t,C c);
}
