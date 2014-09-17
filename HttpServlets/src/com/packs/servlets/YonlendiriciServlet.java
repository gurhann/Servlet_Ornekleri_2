package com.packs.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/yonlendiriciServlet")
public class YonlendiriciServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Gelen metod get ise bu kısım çalışır ve  bilgileriAl.html sayfasına yönlendirilir.
		resp.sendRedirect("bilgileriAl.html");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Gelen metod post ise de bu kısım çalışır
		// İlk başta context den getRequestDispatcher nesnesi alınıp parametre olarak hangi servlet çağrılacağı veriliyor
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/bilgileriYazdirServlet");
		// Daha sonra forward(req, resp) metodu kullanılarak yönlendirme yapılıyor.
		disp.forward(req, resp);
		
	}
}
