package com.xjtu.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//事件监听器[用于监听ServletContext对象产生和销毁]
public class MyServletContextListener implements ServletContextListener{
	public MyServletContextListener(){
		System.out.println("空参构造");
		System.out.println(this.hashCode());
	}
	//产生
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext产生");
		System.out.println(this.hashCode());
	}
	//销毁
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext销毁");
		System.out.println(this.hashCode());
	}
}
