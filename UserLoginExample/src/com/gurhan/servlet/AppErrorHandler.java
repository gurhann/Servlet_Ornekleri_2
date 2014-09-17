package com.gurhan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AppErrorHandler")
public class AppErrorHandler extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		processError(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		processError(req, resp);
	}
	
	private void processError(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//Hatayı analiz et
		Throwable throwable = (Throwable)req.getAttribute("javax.servlet.error.exception");
		Integer statusCode = (Integer)req.getAttribute("javax.servlet.error.status_code");
		String servletName = (String)req.getAttribute("javax.servlet.error.servlet_name");
		
		if(servletName == null) {
			servletName = "Bilinmeyen Servlet";
		}
		
		String requestUri = (String)req.getAttribute("javax.servlet.error.request_uri");
		
		if (requestUri == null) {
			requestUri = "Bilinmeyen Uri";
		}
		
		//Döndürülecek sayfayı ayarla
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		resp.setCharacterEncoding("utf-8");
		out.write("<html><head><title>Hata Detayları</title></head><body>");
        if(statusCode != 500){
            out.write("<h3>Hata Detayları</h3>");
            out.write("<strong>Durum Kodu</strong>:"+statusCode+"<br>");
            out.write("<strong>İstek URI</strong>:"+requestUri);
        }else{
            out.write("<h3>HataDetayları</h3>");
            out.write("<ul><li>Servlet Adı:"+servletName+"</li>");
            out.write("<li>Hata İsmi:"+throwable.getClass().getName()+"</li>");
            out.write("<li>İstek URI:"+requestUri+"</li>");
            out.write("<li>Hata Mesajı:"+throwable.getMessage()+"</li>");
            out.write("</ul>");
        }
        out.write("<br><br>");
        out.write("<a href=\"login.html\">Giriş Sayfası</a>");
        out.write("</body></html>");
	}

}
