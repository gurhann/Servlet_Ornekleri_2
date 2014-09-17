package com.packs.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.jws.soap.InitParam;
import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

public class AnaServlet extends GenericServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Kullanacağımız ServletConfig için bir referans oluşturuyoruz.
	ServletConfig config;
	//Kullanacağımız ServletContext için bir referans oluşturuyoruz.
	ServletContext context;
	@Override
	public void init() throws ServletException {
		//config referansına getServletConfig() metodu ile aldığımız config nesnesini atıyoruz.
		config = getServletConfig();
		//context referansına getServletContext metodu ile aldığımız context nesnesini atıyoruz.
		context = getServletContext();
		context.setAttribute("sayac", 0);
		System.out.println(config.getServletName() + " servleti başlangıç durumuna geçti");
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {
		System.out.println(config.getServletName() + " servleti servis edildi");
		
		//cevabın karakter seti belirtiliyor
		resp.setCharacterEncoding("utf-8");
		//cevabın içerik tipi belirleniyor. biz html sayfası döndürüyoruz.
		resp.setContentType("text/html");
		//Tarayıca bir şey yazdırmamız için PrintWriter nesnesi oluşturuyoruz.
		PrintWriter writer = resp.getWriter();
		
		int sayac = (int) context.getAttribute("sayac") + 1;
		context.setAttribute("sayac", sayac);
		
		writer.print("<html>");
		writer.print("<head>");
		writer.print("<title>");
		writer.print("web.xml kullanımı");
		writer.print("</title>");
		writer.print("</head>");
		writer.print("<body>");
	
			writer.print("param1 in degeri : " + config.getInitParameter("param1" + "<br />"));
			writer.print("<h1><bold>Merhaba Tarayıcı :)</h1></bold><br />");
			writer.print("<a href='/IlkProje/ikinciServlet'>Diğer servleti çalıştırmak için tıklayın</a><br />");
			writer.print("Bu sayfa "+context.getAttribute("sayac")+" kez servis edildi <br />");
			
		writer.print("</body>");
		writer.print("</html>");
		writer.close();
	}

}
