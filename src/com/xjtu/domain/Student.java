package com.xjtu.domain;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

//JavaBean���󣬸�֪���Ѻ�ʱ���ۻ�����ʱ�������Web��������
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
