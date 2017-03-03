package com.xjtu.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//øŒÃ√¡∑œ∞2
public class OnlineListener implements HttpSessionListener {
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		if(session.isNew()){
			ServletContext context = session.getServletContext();
			Integer caller = (Integer) context.getAttribute("caller");
			Integer counter = (Integer) context.getAttribute("counter");
			if(caller==null){
				caller = 1;
			}else{
				caller++;
			}
			if(counter==null){
				counter = 1;
			}else{
				counter++;
			}
			context.setAttribute("counter",counter);
			session.setAttribute("caller",counter);
		}
	}
	public void sessionDestroyed(HttpSessionEvent se) {
	}
}
