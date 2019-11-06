package com.myapp.thread;

class Daemon extends Thread {
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(getName() + "-" + i);
        }
    }
}