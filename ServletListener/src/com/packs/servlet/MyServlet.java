package com.packs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.packs.model.User;
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		ServletContext context = req.getServletContext();
		context.setAttribute("ContextOzellik", "Contexte Atanan Deger");
		context.setAttribute("ContextOzellik", "Değiştirilen Değer");
		context.removeAttribute("ContextOzellik");
		
		HttpSession session = req.getSession();
		session.setAttribute("ozellik", "session özellik");
		User user2 = new User("Gurhan", "Kucuk", 20);
		session.setAttribute("user", user2);
		session.removeAttribute("user2");
		session.invalidate();
		
		
	}

}
