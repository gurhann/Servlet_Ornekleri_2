package com.packs.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/OturumSonlandir")
public class OturumSonlandir extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter writer = resp.getWriter();
		
		writer.print("<html>");
		writer.print("<head>");
		writer.print("<title>");
		writer.print("oturumu sonlandırın");
		writer.print("</title>");
		writer.print("</head>");
		writer.print("<body>");
		
			HttpSession session = req.getSession(false);
			
			if(session == null){
				writer.print("Sonlandırılacak Herhangi bir oturum bulunamadı. <br />");
			}else{
				writer.print(session.getId() + " idli oturum sonlandırılıyor.  <br />");
				session.invalidate();
				
				writer.print("Oturum başarıyla sonlandırıldı.  <br />");
				writer.print("<a href='"+resp.encodeURL("/OturumYonetimi/OturumOlustur")+"'>Tekrar oturum açmak için tıklayın.</a>");
				
			}
				
		writer.print("</body>");
		writer.print("</html>");
		writer.close();
		
	}

}
