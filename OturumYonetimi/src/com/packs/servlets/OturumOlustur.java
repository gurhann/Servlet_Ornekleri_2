package com.packs.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/OturumOlustur")
public class OturumOlustur extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		HttpSession session = req.getSession(false);
		
		writer.print("<html>");
		writer.print("<head>");
		writer.print("<title>");
		writer.print("oturum yönetimi");
		writer.print("</title>");
		writer.print("</head>");
		writer.print("<body>");
		
		if(session == null){
			writer.print("Mevcut oturum bilgisi bulunamadı yeni oturum başlatıldı.  <br />");
			session = req.getSession();
		}else{
			writer.print("Zaten oturum bulunmakta. Tekrar hoşgeldiniz.  <br />");
		}
		
	
			writer.print("<a href='" +resp.encodeURL("/OturumYonetimi/OturumBilgileri") + "'>Oturum Bilgilerini Görmek için tıklayın</a>");
			
		writer.print("</body>");
		writer.print("</html>");
		writer.close();
		
		
	}

}
