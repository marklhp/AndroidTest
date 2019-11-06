package com.myapp.thread.money2;

class Singleton {
	private Singleton() {
	}

	private static Singleton instance;

	/**
	 * ��ʱͬ������������ Singleton.class
	 */
	/**
	 * public synchronized static Singleton getInstance(){ if(instance == null){
	 * instance = new Singleton(); } return instance; }
	 */
	
	/**
	 * 
	 * Spring   : <bean   scope = "singleton"/>
	 * @return
	 */
	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}

}
public class SingletonDemo {

}
