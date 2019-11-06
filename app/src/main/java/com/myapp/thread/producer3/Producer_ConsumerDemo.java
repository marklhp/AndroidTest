package com.myapp.thread.producer3;

/**
 * ģ������
 * 
 */
/*
 * 
 * ������������,��Ҫ���Ǳ�֤ �������ֺ��Ա�ͬ�����,
 */
class Person {

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
	public synchronized void set(String name, String sex) {
		// if(isEmpty)
		while (!isEmpty.equals(Boolean.TRUE)) {
			// ����Ϊ��
			// ��ʱ������Ӧ��ͣ����,��������������
			try {
				this.wait();// �ȴ� ����������
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.name = name;
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.sex = sex;
		// ����������֮��,Ӧ���޸Ĵ洢�����״̬
		isEmpty = Boolean.FALSE;// ��Ϊ��
		this.notifyAll();// ����������,�����Զ�����

	}

	/**
	 * ����
	 */
	public synchronized void get() {
		// �洢����Ϊ��
		while (!isEmpty.equals(Boolean.FALSE)) {
			try {
				this.wait();// ����������ȥ����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		String name = getName();
		String sex = getSex();
		System.out.println(name + " --> " + sex);
		// �������,Ӧ���޸Ĵ洢�����״̬

		isEmpty = Boolean.TRUE;// ����
		this.notifyAll();// ����������,

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

		new Thread(new Producer(p)).start();
		new Thread(new Consumer(p)).start();
	}
}
