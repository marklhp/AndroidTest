package com.myapp.thread.money2;

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

class ATM extends Thread {

	private double drawMoeny;
	private Account a;

	public ATM(double drawMoeny, Account a,String name) {
		super(name);
		this.drawMoeny = drawMoeny;
		this.a = a;
	}

	/**
	 * �̳з�ʽ,ͬ������������ʹ��this
	 */
	public synchronized void run() {
	
		//synchronized (this) {//ERROR
		//synchronized (a) {//TES
		
		//Class clz = ATM.class;ATM��һ���ֽ���
		//synchronized (ATM.class) {//TES
			if (a.getBalance() >= drawMoeny) {// ���>= �����
				System.out.println(Thread.currentThread().getName() + "-->,�³�"
						+ drawMoeny);
				a.setBalance(a.getBalance() - drawMoeny);
				System.out.println(Thread.currentThread().getName() + "ʣ��"
						+ a.getBalance());
			} else {
				System.out.println(Thread.currentThread().getName() + "����"
						+ a.getBalance());
			}
		//}
		
	}

}

public class DrawMoneyDemo {
	public static void main(String[] args) {
		Account a = new Account(1000);
		new ATM(800,a,"A").start();
		new ATM(800,a,"B").start();
	}
}
