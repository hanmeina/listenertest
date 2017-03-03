package com.xjtu.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

//监听器[用于监听属性变化情况]
public class AttributeListener 
	implements ServletContextAttributeListener,
	HttpSessionAttributeListener ,
	ServletRequestAttributeListener{
	public void attributeAdded(ServletContextAttributeEvent scab) {
		System.out.println("属性增加");
		String name = scab.getName();
		String value = (String) scab.getValue();
		System.out.println(name+":"+value);
	}
	public void attributeReplaced(ServletContextAttributeEvent scab) {
		System.out.println("属性修改");
		String name = scab.getName();
		String value = (String) scab.getValue();
		System.out.println(name+":"+value);
	}
	public void attributeRemoved(ServletContextAttributeEvent scab) {
		System.out.println("属性删除");
		String name = scab.getName();
		String value = (String) scab.getValue();
		System.out.println(name+":"+value);
	}
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("属性增加");
		String name = se.getName();
		String value = (String) se.getValue();
		System.out.println(name+":"+value);
	}
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("属性修改");
		String name = se.getName();
		String value = (String) se.getValue();
		System.out.println(name+":"+value);
	}
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("属性删除");
		String name = se.getName();
		String value = (String) se.getValue();
		System.out.println(name+":"+value);
	}
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("属性增加");
		String name = srae.getName();
		String value = (String) srae.getValue();
		System.out.println(name+":"+value);
	}
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("属性修改");
		String name = srae.getName();
		String value = (String) srae.getValue();
		System.out.println(name+":"+value);
	}
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("属性删除");
		String name = srae.getName();
		String value = (String) srae.getValue();
		System.out.println(name+":"+value);
	}
}
