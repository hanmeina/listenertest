package com.xjtu.listener;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.xjtu.domain.User;

//������
public class KickListener implements HttpSessionAttributeListener {
	public void attributeAdded(HttpSessionBindingEvent se) {
		String name = se.getName();//name="username"
		System.out.println("username:"+name);
		String value = (String) se.getValue();//value="jack"
		System.out.println("value:"+value);
		if(name.equals("username")){
			//ȡ�ø��û���Ӧ��HttpSession
			HttpSession session = se.getSession();
			//ȡ�ø�webӦ�õ�SerlvetContext����
			ServletContext context = session.getServletContext();
			Map<String,HttpSession> map = (Map<String, HttpSession>) context.getAttribute("map");
			if(map==null){
				map = new HashMap<String,HttpSession>();
			}
			map.put(value,session);
			context.setAttribute("map",map);
		}
	}
	public void attributeRemoved(HttpSessionBindingEvent se) {
	}
	public void attributeReplaced(HttpSessionBindingEvent se) {
	}
}
