package com.myapp.thread.ticket2;

class MyRunnable implements Runnable {

	private Integer num = 50;

	public void run() {
		for (int i = 0; i < 200; i++) {
			sale();
		}

	}

	synchronized public  void sale() {
		if (num > 0) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "������" + num--
					+ "��");
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
