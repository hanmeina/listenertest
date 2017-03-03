package com.xjtu.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

//JavaBean对象，感知自已何时绑定到HttpSession中，何时从HttpSession中移除
public class User implements HttpSessionBindingListener{
	private String username;
	public User(){}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("valueBound()");
	}
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("valueUnbound()");
	}
}
