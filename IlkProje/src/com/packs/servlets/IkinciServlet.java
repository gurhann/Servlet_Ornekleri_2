package com.packs.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(name="ikinci_servlet",urlPatterns = "/ikinciServlet", 
initParams = {
		@WebInitParam(name="ikinciServletParametreleri1", value="deger1"),
		@WebInitParam(name="ikinciServletParametreleri2", value="deger2"),
		@WebInitParam(name="ikinciServletParametreleri3", value="deger3"),
		@WebInitParam(name="ikinciServletParametreleri4", value="deger4"),
		@WebInitParam(name="ikinciServletParametreleri5", value="deger5"),
		})
public class IkinciServlet extends GenericServlet{

	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		System.out.println(getServletConfig().getServletName() + " servleti başlangıç durumuna geçti");
		
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		PrintWriter writer = resp.getWriter();
		
		Enumeration<String> parametreIsimleri = getServletConfig().getInitParameterNames();
		
		writer.print("<html>");
		writer.print("<head>");
		writer.print("<title>");
		writer.print("web.xml kullanımı");
		writer.print("</title>");
		writer.print("</head>");
		writer.print("<body>");
			while (parametreIsimleri.hasMoreElements()) {
				//Enumeration listesinden sıradaki parametre alınıyor
				String parametreIsmi = parametreIsimleri.nextElement();
				//alınan parametre isminin servlet config kullanılarak değerine bakılıyor
				String degeri = getServletConfig().getInitParameter(parametreIsmi);
				writer.print(parametreIsmi + " : " + degeri + "<br />");
			}
			writer.print("ana servlet " + getServletContext().getAttribute("sayac") + " kez çağrıldı");
		writer.print("</body>");
		writer.print("</html>");
		
	}

}
