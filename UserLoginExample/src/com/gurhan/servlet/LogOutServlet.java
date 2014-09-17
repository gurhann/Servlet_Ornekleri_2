package com.gurhan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@WebServlet("/LogOut")
public class LogOutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(LogOutServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cookie [] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("JSESSIONID")) {
					logger.info("JSESSIONID=" + cookie.getValue());
					break;
				}
			}
		}
		
		HttpSession session = req.getSession(false);
		logger.info("Kullanıcı=" + session.getAttribute("User"));
		if (session != null) {
			session.invalidate();
		}
		
		resp.sendRedirect("login.html");
	}
	
}
