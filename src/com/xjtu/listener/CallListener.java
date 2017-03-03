package com.xjtu.listener;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

//单例
public class CallListener implements ServletRequestListener {
	private static Map<String,String> map = new HashMap<String,String>();
	//实例变量
	private int counter;
	static{
		map.put("127.0.0.1","广州");
		map.put("192.168.10.96","深圳");
		map.put("192.168.10.113","中山");
		map.put("192.168.10.124","珠海");
	}
	public void requestInitialized(ServletRequestEvent sre) {
		synchronized (this) {
			this.counter++;
		}
		//取得事件源,即ServletRequest对象
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		//取得客户端IP
		String ip = request.getRemoteAddr();
		//通过ip查询归属地
		String address = map.get(ip);
		if(address==null){
			address = "北京";
		}
		//绑定到域对象
		request.setAttribute("ip",ip);
		request.setAttribute("address",address);
		request.setAttribute("counter",this.counter);
	}
	public void requestDestroyed(ServletRequestEvent sre) {
	}
}
