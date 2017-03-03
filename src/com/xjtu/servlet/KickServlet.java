package com.xjtu.servlet;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//���˹���
public class KickServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ip = request.getRemoteAddr();
      System.out.println(ip);   
		if ("0:0:0:0:0:0:0:1".equals(ip)) {

			// ����
			String username = request.getParameter("username");
			//byte[] buf = username.getBytes("ISO8859-1");
			//username = new String(buf, "UTF-8");

			// ��ServletContext��ȡ��Map����
			Map<String, HttpSession> map = (Map<String, HttpSession>) this.getServletContext().getAttribute("map");

			// �����û������Ҷ�Ӧ��HttpSession
			HttpSession session = map.get(username);

			// �����û�����Map���Ƴ�
			map.remove(username);

			// ǿ�����ٸ�HttpSession
			session.invalidate();

			// ��д��manager.jsp
			response.sendRedirect(request.getContextPath() + "/manager.jsp");

		}
	}
}
