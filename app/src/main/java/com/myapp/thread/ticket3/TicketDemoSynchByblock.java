package com.myapp.thread.ticket3;

import java.util.concurrent.locks.ReentrantLock;

class MyRunnable implements Runnable {

	private final ReentrantLock lock = new ReentrantLock();
	private Integer num = 50;

	public void run() {
		for (int i = 0; i < 200; i++) {
			sale();
		}

	}

	public void sale() {

		lock.lock();
		try {
			if (num > 0) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "������"
						+ num-- + "��");
			}
		} finally {
			lock.unlock();
		}
	}

}

public class TicketDemoSynchByblock {
	public static void main(String[] args) {

		Runnable target = new MyRunnable();
		new Thread(target, "A").start();
		new Thread(target, "B").start();
		new Thread(target, "C").start();
	}
}
