package com.myapp.thread;

class House{
	
}

class Man extends Thread{
	
	House h;
	public Man(House h){
		this.h = h;
	}
	public void run() {
		synchronized (h) {
			System.out.println("��������");
		}
	}
}

public class DeadLockDemo {
	public static void main(String[] args) {
		
		House  h = new House();
		Man m = new Man(h);
		m.start();
		
		synchronized (h) {
			try {
				m.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("�޸���Ŷ");
		}
	}
}
