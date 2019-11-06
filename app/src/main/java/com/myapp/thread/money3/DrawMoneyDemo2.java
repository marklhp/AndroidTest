package com.myapp.thread.money3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * �˺�
 */
class Account2 {

	//����������������
	private final  ReentrantLock lock = new ReentrantLock();
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

class ATM2 implements Runnable{

	

	
	private double drawMoeny;
	private Account2 a;

	public ATM2(double drawMoeny, Account2 a) {
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
	 *   	}
	 *  	
	 * 
	 */
	public void run() {
		a.draw(drawMoeny);
	}

}

public class DrawMoneyDemo2 {
	public static void main(String[] args) {
		Account2 a = new Account2(1000);
		ATM2 atm = new ATM2(800,a);
		new Thread(atm,"С2").start();
		new Thread(atm,"С3").start();
		
		//StringBuilder  /  StringBuffer
	}
}
