package com.xjtu.listener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//HttpSession扫描器
public class SessionScanner implements ServletContextListener,HttpSessionListener{
	private List<HttpSession> sessionList = new ArrayList<HttpSession>();
	//线程安全
	private Timer timer = new Timer();
	
	public SessionScanner(){
		//将线程不安全的List转换成线程安全的List
		sessionList = Collections.synchronizedList(sessionList);
	}
	
	//ServletContext产生
	public void contextInitialized(ServletContextEvent sce) {
		timer.schedule(new SessionTask(this.sessionList),0,1*1000);
	}
	//HttpSession产生
	public void sessionCreated(HttpSessionEvent se) {
		//取得客户端产生的HttpSession
		HttpSession session = se.getSession();
		System.out.println("HttpSession产生" + session.hashCode() + new Date().toLocaleString());
		synchronized (sessionList) {
			//将HttpSession加入到容器中
			this.sessionList.add(session);
		}
	}
	//ServletContext销毁
	public void contextDestroyed(ServletContextEvent sce) {
		timer.cancel();
	}
	//HttpSession销毁
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		System.out.println("HttpSession销毁" + session.hashCode() + new Date().toLocaleString());
	}
}

//任务类
class SessionTask extends TimerTask{
	private List<HttpSession> sessionList;
	public SessionTask(List<HttpSession> sessionList) {
		this.sessionList = sessionList;
	}
	public void run() {
		System.out.println("run()");
		//迭代集合
		//Iterator<HttpSession> it = sessionList.iterator();
		synchronized (sessionList) {
			ListIterator<HttpSession> it = sessionList.listIterator();
			while (it.hasNext()) {
				HttpSession session = it.next();
				//判段HttpSession是否1分钟未被使用
				int middle = (int) ((System.currentTimeMillis() - session
						.getLastAccessedTime()) / 1000);
				if (middle > 60) {
					//将该HttpSession销毁
					session.invalidate();
					//从集合中删除该HttpSession
					//sessionList.remove(session);
					it.remove();
				}
			}
		}
		
	}
}

