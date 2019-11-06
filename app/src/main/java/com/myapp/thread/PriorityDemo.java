package com.myapp.thread;

class Priority implements Runnable{

	public void run() {
		
		for (int i = 0; i < 200; i++) {
			System.out.println("Priority-- " + i);
		}
	}
	
}
/**
 * ÿ���̶߳������ȼ������ȼ��ĸߵ�ֻ���̻߳��ִ�л���Ĵ��������йء�
	�����߳����ȼ�Խ�ߵľ�һ����ִ�У��ĸ��̵߳�������ȡ����CPU�ĵ���;
	Ĭ�������main�߳̾�����ͨ�����ȼ��������������߳�Ҳ������ͨ���ȼ���
	Thread�����setPriority(int x)��getPriority()�����úͻ�����ȼ���
	MAX_PRIORITY	:	ֵ��10
	MIN_PRIORITY	:	ֵ��1
	NORM_PRIORITY	:	ֵ��5(������Ĭ�����ȼ�)

 *
 */
public class PriorityDemo {
	public static void main(String[] args) {
		
		/**
		 * �̵߳����ȼ���[1,10]֮��
		 */
		Thread.currentThread().setPriority(3);
		System.out.println("main= " + Thread.currentThread().getPriority());
		/*
		 *  public final static int MIN_PRIORITY = 1;
		 *  public final static int NORM_PRIORITY = 5;
		 *  public final static int MAX_PRIORITY = 10;
		 * */
		System.out.println(Thread.MAX_PRIORITY);
		
		//===============================================
		
		Thread t = new Thread(new Priority());
		for (int i = 0; i < 200; i++) {
			System.out.println("main" + i);
			if(i == 50){
				t.start();
				t.setPriority(10);
			}
			System.out.println("-------------------------"+t.getPriority());
		}
	}
}
