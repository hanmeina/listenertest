package com.xjtu.gui.frame;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//��ʱ��
public class Demo2 {	
	public static void main(String[] args) {
		//������ʱ��
		Timer timer = new Timer();
		//ָ��ÿ1����ִ��һ��
		/*
		 * ����һ�����������
		 * ����������һ��ִ��ǰ���ӳ�ʱ�䣬��λ����
		 * ��������ÿ������ʱ��ִ��һ��
		 */
		//timer.schedule(new MyTimerTask(),0,1000);
		
		//ָ��ʱ��ִ��һ��
		Calendar c = Calendar.getInstance();
		c.set(2011,10,6,10,30,40);
		timer.schedule(new MyTimerTask(),c.getTime());
	}
}
//�߳�����
class MyTimerTask extends TimerTask{
	public void run() {
		Date date = new Date();
		System.out.println(date.toLocaleString());
	}
}

