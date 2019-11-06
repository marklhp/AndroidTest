package com.myapp.thread;

class  Join implements Runnable{

	public void run() {
		for (int i = 0; i < 200; i++) {
			System.out.println("join --> " + i);
		}
	}
	
}
public class JoinDemo {
	public static void main(String[] args) throws Exception {
		Thread t =new Thread(new Join());
		for (int i = 0; i < 200; i++) {
			System.out.println("main----->" + i);
			if(i == 50){
				t.start();
			}
			if(i == 100){
				//���̵߳ȴ�tִ����,����ִ��
				//tǿ������,
				t.join();
			}
		}
	}
}
