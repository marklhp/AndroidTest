package com.myapp.thread;

class XX extends  Thread{
	public void run() {
		/**
		 *run��������쳣,ͳͳ����,����
		 */
		for (int i = 0; i < 100; i++) {
			System.out.println("-->" + i);
		}
	}
}
public class ThreadDemo {
	public static void main(String[] args) {
		
		XX x = new XX();
		x.start();
		x.start();
		x.start();
	}
}
