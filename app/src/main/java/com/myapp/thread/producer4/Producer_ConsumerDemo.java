package com.myapp.thread.producer4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ģ������
 * 
 */
/*
 * 
 * ������������,��Ҫ���Ǳ�֤ �������ֺ��Ա�ͬ�����,
 * 
 * 
 * ��������û��ͬ����������,զ����?
 * 
 * Lock ����� synchronized ����������ʹ�ã�Condition ����� Object ������������ʹ�á� 
 */
class Person {

	// ����������������
	private final ReentrantLock lock = new ReentrantLock();
	
	private  final  Condition con = lock.newCondition();
	private String name;

	private String sex;

	// ��ʾ�洢�����Ƿ�Ϊ��
	private Boolean isEmpty = Boolean.TRUE;

	/**
	 * ����
	 * 
	 * @param name
	 * @param sex
	 */
	public void set(String name, String sex) {
		lock.lock();
		while(!isEmpty.equals(Boolean.TRUE)){
			//��ʾ����״̬
			try {
				con.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			this.name = name;
			Thread.sleep(1);
			this.sex = sex;
			isEmpty = Boolean.FALSE;
			con.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		

	}

	/**
	 * ����
	 */
	public void get() {
		lock.lock();
		while(!isEmpty.equals(Boolean.FALSE)){
			//�洢����Ϊ��,������Ӧ�õ���
			try {
				con.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			String name = getName();
			String sex = getSex();
			System.out.println(name + " --> " + sex);
			//
			isEmpty = Boolean.TRUE;
			con.signal();
		} finally {
			lock.unlock();
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}

/**
 * ������
 */
class Producer implements Runnable {

	private Person p;

	public Producer(Person p) {
		this.p = p;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) {
				p.set("�����", "��");
			} else {
				p.set("����", "Ů");
			}
		}
	}
}

class Consumer implements Runnable {
	private Person p;

	public Consumer(Person p) {
		this.p = p;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			p.get();
		}
	}

}

public class Producer_ConsumerDemo {
	public static void main(String[] args) {
		Person p = new Person();

		new Thread(new Producer(p)).start();
		new Thread(new Consumer(p)).start();

	}
}
