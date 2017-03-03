package com.xjtu.listener;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//监听器[用于监听HttpSesison产生和销毁]
public class MyHttpSessionListener implements HttpSessionListener {
	//产生
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		System.out.println(session.getId());
		System.out.println("sessionCreated()" + new Date().toLocaleString());
	}
	//销毁
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		System.out.println(session.getId());
		System.out.println("sessionDestroyed()");
		System.out.println("sessionCreated()" + new Date().toLocaleString());
	}
}
