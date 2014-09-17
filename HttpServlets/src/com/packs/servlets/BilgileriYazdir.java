package com.packs.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bilgileriYazdirServlet")
public class BilgileriYazdir extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		
		PrintWriter writer = resp.getWriter();
		//requestten sayfadaki parametreler alınıyor.
		Enumeration<String> parametreIsimleri = req.getParameterNames();
		
		writer.print("<html>");
		writer.print("<head>");
		writer.print("<title>");
		writer.print("web.xml kullanımı");
		writer.print("</title>");
		writer.print("</head>");
		writer.print("<body>");
			writer.print("<h3>Girdiğiniz Bilgiler</h3>");
			
			while (parametreIsimleri.hasMoreElements()) {
				//sıradaki parametre ismi alınıyor
				String parametreIsmi = parametreIsimleri.nextElement();
				
				// Eğer sıra programlama_dillerindeyse burda bize bir dizi dönecek
				//onun için ayrıyeten işlem yapıyoruz.
				if (parametreIsmi.equals("programlama_dilleri")) {
					// Birden fazla değer almak için getParameterValues() kullanılır.
					String [] degerler = req.getParameterValues(parametreIsmi);
					writer.print(parametreIsmi + " isimli parametrenin değerleri : ");
					for (String s : degerler) {
						writer.print(s+" ");
					}
					writer.print("<br />");
					continue;
				}
				// Tek bir değer almak için isede getParameter() kullanılır.
				String deger = req.getParameter(parametreIsmi);
				writer.print(parametreIsmi + " isimli parametrenin değeri : " + deger + "<br />");
				
				
			}
		writer.print("</body>");
		writer.print("</html>");
		writer.close();
		
	}

}
