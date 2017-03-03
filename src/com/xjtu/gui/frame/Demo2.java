package com.xjtu.gui.frame;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//定时器
public class Demo2 {	
	public static void main(String[] args) {
		//创建定时器
		Timer timer = new Timer();
		//指定每1秒钟执行一次
		/*
		 * 参数一：任务类对象
		 * 参数二：第一次执行前的延迟时间，单位毫秒
		 * 参数三：每隔毫秒时间执行一次
		 */
		//timer.schedule(new MyTimerTask(),0,1000);
		
		//指定时间执行一次
		Calendar c = Calendar.getInstance();
		c.set(2011,10,6,10,30,40);
		timer.schedule(new MyTimerTask(),c.getTime());
	}
}
//线程任务
class MyTimerTask extends TimerTask{
	public void run() {
		Date date = new Date();
		System.out.println(date.toLocaleString());
	}
}

