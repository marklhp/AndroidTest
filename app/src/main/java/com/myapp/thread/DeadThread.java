package com.myapp.thread;

class DeadThread extends Thread {
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(getName() + "--" + i);
        }
    }
}