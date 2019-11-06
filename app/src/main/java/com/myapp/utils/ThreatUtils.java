package com.myapp.utils;

public class ThreatUtils {
    //获取当前应用线程总数
    private int getCurrentAppAccount(){
        return Thread.getAllStackTraces().size();
    }
}
