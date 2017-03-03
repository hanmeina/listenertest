package com.xjtu.domain;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

//JavaBean对象，感知自已何时被钝化，何时被激活，由Web容器决定
public class Student implements HttpSessionActivationListener{
	private String username;
	public Student(){}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void sessionDidActivate(HttpSessionEvent se) {
	}
	public void sessionWillPassivate(HttpSessionEvent se) {
	}
}
