package com.myapp.thread.money3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * �˺�
 */
class Account {

	//����������������
	private final  ReentrantLock lock = new ReentrantLock();
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
	
	public void draw(double drawMoeny){
		//����
				lock.lock();//��ȡ��
				
				try{
					if (getBalance() >= drawMoeny) {// ���>= �����
						System.out.println(Thread.currentThread().getName() + "-->,�³�"
								+ drawMoeny);
						setBalance(getBalance() - drawMoeny);
						System.out.println(Thread.currentThread().getName() + "ʣ��"
								+ getBalance());
					} else {
						System.out.println(Thread.currentThread().getName() + "����"
								+ getBalance());
					}
					
				}finally{
					//���,����,����
					lock.unlock();
				}

	}
}

class ATM extends Thread {

	

	
	private double drawMoeny;
	private Account a;

	public ATM(double drawMoeny, Account a, String name) {
		super(name);
		this.drawMoeny = drawMoeny;
		this.a = a;
	}

	/**
	 * ��3��ͬ����ʽ:
	 * 
	 * java.util.concurrent.locks.Lock�ӿ�
	 * java.util.concurrent.locks.ReentrantLock��
	 * 		ReentrantLock,��������,û��ͬ����������
	 * 
	 *  
	 *  ��ʽ:
	 *  
	 *  	private final ReentrantLock lock= new ReentrantLock();//��������һ������
	 *  
	 *   	public void  m(){
	 *   		//���뷽����һ����,����
	 *   		lock.lock();//��ȡ��
	 *   
	 *   		try{
	 *   			//��Ҫͬ���Ĵ���
	 *   		}finally{
	 *   			lock.unlock();//����,����
	 *   		}
	 *   
	 *   
	 *   	}
	 *  	
	 * 
	 */
	public void run() {
		a.draw(drawMoeny);
	}

}

public class DrawMoneyDemo {
	public static void main(String[] args) {
		Account a = new Account(1000);
		new ATM(800, a, "A").start();
		new ATM(800, a, "B").start();
	}
}
