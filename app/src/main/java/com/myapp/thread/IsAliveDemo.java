package com.myapp.thread;

class MyRunnable implements Runnable{

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("���߳�=  "+ i);
		}
	}
}
public class IsAliveDemo {
	public static void main(String[] args) {
		
		Thread t = new Thread(new MyRunnable()); 
		for (int i = 0; i < 200; i++) {
			System.out.println("main " +i );
			if(i == 50 ){
				t.start();
			}
		}
		//�߳�һ������,�Ͳ�����ʹ�� start����������,
		//Exception in thread "main" java.lang.IllegalThreadStateException
		if(!t.isAlive()){
			t.start();
		}
	}
}
