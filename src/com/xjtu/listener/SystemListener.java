package com.xjtu.listener;

import java.util.Timer;

import java.util.TimerTask;
import java.util.UUID;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.xjtu.dao.SystemDao;


public class SystemListener implements ServletContextListener {
	private Timer timer = new Timer();
	public void contextInitialized(ServletContextEvent sce) {
		try {
			SystemDao systemDao = new SystemDao();
			systemDao.createTable("systemInit");
			timer.schedule(new SystemTask(),0,5*1000);
			
			//System.out.println("contextInitialized");
		
		} catch (Exception e) {
		}
	}
	public void contextDestroyed(ServletContextEvent sce) {
		try {
			SystemDao systemDao = new SystemDao();
			systemDao.dropTable("systemInit");
			//中止定时器
			timer.cancel();
		//	System.out.println("contextDestroyed");
		} catch (Exception e) {
		}
	}
}
//任务类
class SystemTask extends TimerTask{
	public void run() {
		try {
			SystemDao systemDao = new SystemDao();
			systemDao.init("systemInit",UUID.randomUUID().toString());
		} catch (Exception e) {
		}
	}
}





