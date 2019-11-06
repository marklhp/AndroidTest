package com.myapp.thread;

class  MyThread extends Thread{
    boolean flag = true;
    public void run() {
        int i = 0;
        while (flag) {
            if (i == 25) {
                flag = false;
            }
            System.out.println("==" + i);
            i++;
        }
    }
}