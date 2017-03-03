package com.xjtu.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

//监听器[用于监听ServletRequest对象的产生和销毁]
public class MyServletRequestListener implements ServletRequestListener {
	//产生
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("requestInitialized()");
	}
	//销毁
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("requestDestroyed()");
	}
}
