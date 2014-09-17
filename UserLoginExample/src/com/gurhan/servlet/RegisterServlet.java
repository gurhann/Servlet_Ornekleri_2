package com.gurhan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(RegisterServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String country = req.getParameter("country");
		String errorMessage = null;
		
		if (email == null || email.equals("")) {
			errorMessage = "Email boş olamaz";
		}
		if (password == null || password.equals("")) {
			errorMessage = "Şifre boş olamaz";
		}
		if (name == null || name.equals("")) {
			errorMessage = "İsim boş olamaz";
		}
		if (country == null || country.equals("")) {
			errorMessage = "Ülke boş olamaz";
		}
		
		if(errorMessage != null) {
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/register.html");
			PrintWriter out = resp.getWriter();
			out.print("<font color=red>"+errorMessage+"</font>");
			disp.include(req, resp);
		} else {
			Connection con = (Connection)getServletContext().getAttribute("DBConnection");
			PreparedStatement psmt = null;
			
			try {
				psmt = con.prepareStatement("insert into users(name,email,country,password) values(?,?,?,?)");
				psmt.setString(1, name);
				psmt.setString(2, email);
				psmt.setString(3, country);
				psmt.setString(4, password);
				
				psmt.executeUpdate();
				logger.info("Kullanıcı kaydedildi : " + email);
				
				RequestDispatcher disp = getServletContext().getRequestDispatcher("/login.html");
				PrintWriter out= resp.getWriter();
	            out.println("<font color=green>Kayıt Başarılı Lütfen Giriş Yapınız.</font>");
	            disp.include(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("Veri tabanı bağlantı problemi");
				throw new ServletException("Veritabanı Bağlantı Problemi");
			} finally {
				try {
					psmt.close();
				} catch (SQLException e) {
					logger.info("PrepareStament kapatılırken hata");
				}
			}
		}
	}
}
