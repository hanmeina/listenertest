package com.xjtu.listener;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

//����
public class CallListener implements ServletRequestListener {
	private static Map<String,String> map = new HashMap<String,String>();
	//ʵ������
	private int counter;
	static{
		map.put("127.0.0.1","����");
		map.put("192.168.10.96","����");
		map.put("192.168.10.113","��ɽ");
		map.put("192.168.10.124","�麣");
	}
	public void requestInitialized(ServletRequestEvent sre) {
		synchronized (this) {
			this.counter++;
		}
		//ȡ���¼�Դ,��ServletRequest����
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		//ȡ�ÿͻ���IP
		String ip = request.getRemoteAddr();
		//ͨ��ip��ѯ������
		String address = map.get(ip);
		if(address==null){
			address = "����";
		}
		//�󶨵������
		request.setAttribute("ip",ip);
		request.setAttribute("address",address);
		request.setAttribute("counter",this.counter);
	}
	public void requestDestroyed(ServletRequestEvent sre) {
	}
}
