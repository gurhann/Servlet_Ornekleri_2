package com.packs.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/OturumBilgileri")
public class OturumBilgileri extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter writer = resp.getWriter();
		
		HttpSession session = req.getSession();
		
		writer.print("<html>");
		writer.print("<head>");
		writer.print("<title>");
		writer.print("web.xml kullanımı");
		writer.print("</title>");
		writer.print("</head>");
		writer.print("<body>");
		
			writer.print("Oturum id si: " + session.getId() + "<br />");
			writer.print("Oturum oluşturulma zamanı: " + new Date(session.getCreationTime()) + "<br />");
			writer.print("Oturuma son erişilme zamanı: " + new Date(session.getLastAccessedTime()) + "<br />");
			writer.print("<a href='"+resp.encodeURL("/OturumYonetimi/OturumSonlandir")+"'>Oturumu Sonlandırmak için tıklayın.</a>");
		
		writer.print("</body>");
		writer.print("</html>");
		writer.close();
	}

}
