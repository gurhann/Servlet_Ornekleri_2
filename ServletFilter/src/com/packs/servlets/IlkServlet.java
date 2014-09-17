package com.packs.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/IlkServlet")
public class IlkServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("İlk Servlet doGet Metodu Çalıştı");
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/IkinciServlet");
		disp.forward(req, resp);
	}
}
