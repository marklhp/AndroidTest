package com.myapp.thread;

public class DieThreadDemo {
    public static void main(String[] args) {
        DeadThread dt = new DeadThread();
        for (int i = 0; i < 100; i++) {
            Thread currentThread = Thread.currentThread();//获得当前线程（Main线程）
            System.out.println(currentThread.getName() + "--" + i);
            System.out.println("------>"+ currentThread.isAlive());
            if (i == 10) {
                dt.start();
            }
        }
        if (!dt.isAlive()) {
            dt.start();
        }
    }


}


