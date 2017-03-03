package com.xjtu.listener;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//������[���ڼ���HttpSesison����������]
public class MyHttpSessionListener implements HttpSessionListener {
	//����
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		System.out.println(session.getId());
		System.out.println("sessionCreated()" + new Date().toLocaleString());
	}
	//����
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		System.out.println(session.getId());
		System.out.println("sessionDestroyed()");
		System.out.println("sessionCreated()" + new Date().toLocaleString());
	}
}
