package com.myapp.thread;


/**
 *		�Ƚ����ַ�ʽ������:
 *			
 *			ʹ�ü̳з�ʽ,��Դ���ܹ���;
 *
 *			�̳з�ʽ,�̳���Thread��֮��,�Ͳ����ټ̳���������;
 *
 *			
 *			�Ӵ���ļ�������,��˵�̳з�ʽ��Щ
 *
 *
 *		�Ƽ�ʹ�� �ӿڷ���,  �����Ժ���չ;,��Դ����
 *			
 * 			
 *
 */

class Ticket2 extends Object implements Runnable{

	
	int num = 50;
	@Override
	public void run() {
		for (int i = 0; i < 200; i++) {
			if(num >0) {
				System.out.println(Thread.currentThread().getName()+"--" +num-- +"==");
			}
		}
	}
	
}
public class TicketDemo2 {
	public static void main(String[] args) {
		Runnable target = new Ticket2();
		new Thread(target,"A").start();
		new Thread(target,"B").start();
		new Thread(target,"C").start();
	}
}
