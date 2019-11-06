package com.myapp.thread;

class Yield implements Runnable{

	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(Thread.currentThread().getName()+"-->" + i);
			if(i % 2 == 0){
				//iΪż����ʱ��,����
				Thread.yield();
			}
		}
	}
	
}
public class YieldDemo {
	public static void main(String[] args) {
		Yield y = new Yield();
		new Thread(y,"     �ϴ�").start();
		new Thread(y,"С��").start();
		
		
	}
}
