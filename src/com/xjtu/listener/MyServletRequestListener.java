package com.xjtu.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

//������[���ڼ���ServletRequest����Ĳ���������]
public class MyServletRequestListener implements ServletRequestListener {
	//����
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("requestInitialized()");
	}
	//����
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("requestDestroyed()");
	}
}
