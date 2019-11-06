package com.myapp.thread;

import java.util.Calendar;
import java.util.Date;


class Time implements Runnable{

	public void run() {
		
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		
		StringBuilder sb = new StringBuilder("ϵͳʱ��: ");
		int y = c.get(Calendar.YEAR);
		int m = c.get(Calendar.MONTH) + 1;
		int d = c.get(Calendar.DATE);
		int h = c.get(Calendar.HOUR_OF_DAY);
		int mm = c.get(Calendar.MINUTE);
		int s = c.get(Calendar.SECOND);
		
		String hour = "0";
		String min = "0";
		String se = "0";
		if(h < 10){
			hour+=h;
		}else{
			hour = h+"";
		}
		if(mm < 10){
			min+=mm;
		}else{
			min = mm+"";
		}
		if(s < 10){
			se+=s;
		}else{
			se = s+"";
		}
		
		sb.append(y).append("��")
		.append(m).append("��")
		.append(d).append("��")
		.append(hour).append("ʱ")
		.append(min).append("��")
		.append(se).append("��")
		;
		
		System.out.println(sb.toString());
	}
	
}
public class TimeDemo {
	public static void main(String[] args) throws InterruptedException {
		
		while(true){
			Thread.sleep(1000);
			new Thread(new Time()).start();
		}
	}
}

