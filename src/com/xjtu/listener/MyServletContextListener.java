package com.xjtu.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//�¼�������[���ڼ���ServletContext�������������]
public class MyServletContextListener implements ServletContextListener{
	public MyServletContextListener(){
		System.out.println("�ղι���");
		System.out.println(this.hashCode());
	}
	//����
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext����");
		System.out.println(this.hashCode());
	}
	//����
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext����");
		System.out.println(this.hashCode());
	}
}
