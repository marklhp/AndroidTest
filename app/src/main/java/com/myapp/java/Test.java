package com.myapp.java;

import android.os.Bundle;

import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

class Test {
    public static void main(String[] args){
        MyTheadTest myTheadTest=new MyTheadTest();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10000;i++){
                    myTheadTest.add();
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10000;i++){
                    MyTheadTest.add();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("线程结果打印"+MyTheadTest.a);
    }
}
