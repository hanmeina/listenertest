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

//HttpSessionɨ����
public class SessionScanner implements ServletContextListener,HttpSessionListener{
	private List<HttpSession> sessionList = new ArrayList<HttpSession>();
	//�̰߳�ȫ
	private Timer timer = new Timer();
	
	public SessionScanner(){
		//���̲߳���ȫ��Listת�����̰߳�ȫ��List
		sessionList = Collections.synchronizedList(sessionList);
	}
	
	//ServletContext����
	public void contextInitialized(ServletContextEvent sce) {
		timer.schedule(new SessionTask(this.sessionList),0,1*1000);
	}
	//HttpSession����
	public void sessionCreated(HttpSessionEvent se) {
		//ȡ�ÿͻ��˲�����HttpSession
		HttpSession session = se.getSession();
		System.out.println("HttpSession����" + session.hashCode() + new Date().toLocaleString());
		synchronized (sessionList) {
			//��HttpSession���뵽������
			this.sessionList.add(session);
		}
	}
	//ServletContext����
	public void contextDestroyed(ServletContextEvent sce) {
		timer.cancel();
	}
	//HttpSession����
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		System.out.println("HttpSession����" + session.hashCode() + new Date().toLocaleString());
	}
}

//������
class SessionTask extends TimerTask{
	private List<HttpSession> sessionList;
	public SessionTask(List<HttpSession> sessionList) {
		this.sessionList = sessionList;
	}
	public void run() {
		System.out.println("run()");
		//��������
		//Iterator<HttpSession> it = sessionList.iterator();
		synchronized (sessionList) {
			ListIterator<HttpSession> it = sessionList.listIterator();
			while (it.hasNext()) {
				HttpSession session = it.next();
				//�ж�HttpSession�Ƿ�1����δ��ʹ��
				int middle = (int) ((System.currentTimeMillis() - session
						.getLastAccessedTime()) / 1000);
				if (middle > 60) {
					//����HttpSession����
					session.invalidate();
					//�Ӽ�����ɾ����HttpSession
					//sessionList.remove(session);
					it.remove();
				}
			}
		}
		
	}
}

