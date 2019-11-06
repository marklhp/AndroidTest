package com.myapp.thread.money;

/**
 * �˺�
 */
class Account {

	// ���
	private double balance;

	public Account(double balance) {
		super();
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}

class ATM implements Runnable {

	private double drawMoeny;
	private Account a;

	public ATM(double drawMoeny, Account a) {
		this.drawMoeny = drawMoeny;
		this.a = a;
	}

	// �߳���дȡǮ�Ĳ���
	/**
	 * 
	 * 
	 * ��ʱ���ԭ����: �����߳�ͬʱ��������˺�
	 * 
	 * �������:��֤ȡǮ���޸����ͬʱ���, 1. ʹ��ͬ�������,synchronized(obj){},����Ҫһ��ͬ����������, 2.
	 * ʹ��ͬ������,ʹ��synchronizedȥ����,��Ҫͬ���ķ���
	 */

	Object o = new Object();

	// public synchronized void run() {

	public void run() {
		/**
		 * ��ͬ�������ʹ��this��Ϊͬ������������,��ôֱ��ʵ��Runnable�ſ���ʹ��
		 */

		synchronized (this) {// aҲ����

			if (a.getBalance() >= drawMoeny) {// ���>= �����
				System.out.println(Thread.currentThread().getName() + "-->,�³�"
						+ drawMoeny);

				// ȡǮ��,���ļ�
				// �޸��˺����
				a.setBalance(a.getBalance() - drawMoeny);
				System.out.println(Thread.currentThread().getName() + "ʣ��"
						+ a.getBalance());
			} else {
				System.out.println(Thread.currentThread().getName() + "����"
						+ a.getBalance());
			}
		}
	}

}

public class DrawMoneyDemo {
	public static void main(String[] args) {
		Account a = new Account(1000);

		ATM atm = new ATM(800, a);
		new Thread(atm, "A").start();
		new Thread(atm, "B").start();
	}
}
