package com.myapp.thread.money2;

/**
 * �˺�
 */
class Account2 {

	// ���
	private double balance;

	public Account2(double balance) {
		super();
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	//ͬ������
	//ȡǮ
	/**
	 * ͬ��������ͬ������������:   ���÷����ǷǾ�̬����ô����this
	 * @param drawMoeny		�������Ǿ�̬��ô����ͬ�������������  Class clz  =  Account2.class;(һ���ֽ���)
	 */
	public  synchronized void draw(double drawMoeny){
		if (balance >= drawMoeny) {// ���>= �����
			System.out.println(Thread.currentThread().getName() + "-->,�³�"
					+ drawMoeny);

			// ȡǮ��,���ļ�
			// �޸��˺����
			setBalance(balance - drawMoeny);
			System.out.println(Thread.currentThread().getName() + "ʣ��"
					+ balance);
		} else {
			System.out.println(Thread.currentThread().getName() + "����"
					+ getBalance());
		}
	}
}

class ATM2 extends Thread  {

	private double drawMoeny;
	private Account2 a;

	public ATM2(double drawMoeny, Account2 a,String name) {
		super(name);
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


	public void run() {
		a.draw(drawMoeny);
	}

}

public class CopyOfDrawMoneyDemo2 {
	public static void main(String[] args) {
		Account2 a = new Account2(1000);

		new ATM2(800,a,"A").start();
		new ATM2(800,a,"C").start();
	}
}
