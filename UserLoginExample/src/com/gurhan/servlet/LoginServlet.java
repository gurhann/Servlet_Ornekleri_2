package com.gurhan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.gurhan.util.User;
@WebServlet("/Login")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	static Logger logger = Logger.getLogger(LoginServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		String errorMessage = null;
		
		if (email == null || email.equals("")) {
			errorMessage = "Emaili boş bırakmayın";
		}
		if (password ==null || password.equals("")) {
			errorMessage = "Şifreyi boş bırakmayın";
		}
		
		if(errorMessage != null) {
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out  = resp.getWriter();
			out.print("<font color=red>"+errorMessage+"</font>");
			disp.include(req, resp);
		} else {
			Connection con = (Connection)getServletContext().getAttribute("DBConnection");
			PreparedStatement psmt = null;
			ResultSet rs = null;
			
			try{
				psmt = con.prepareStatement("select id, name, email, country from users where email = ? and password = ?");
				psmt.setString(1, email);
				psmt.setString(2, email);
				rs = psmt.executeQuery();
				
				if(rs != null && rs.next()) {
					User user = new User(rs.getString("name"), email, rs.getString("country"), rs.getInt("id"));
					logger.info("Kullanıcı :" + user);
					HttpSession session = req.getSession();
					session.setAttribute("User", user);
					resp.sendRedirect("home.jsp");
				} else {
					RequestDispatcher disp = getServletContext().getRequestDispatcher("/login.html");
					PrintWriter out = resp.getWriter();
					logger.error("Kullanıcı Bulunamadı :" + email);
					out.print("<font color=red>Bu Emailde kullanıcı yok lütfen kayıt olun");
					disp.include(req, resp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("Veri tabanı bağlantı problemi");
				throw new ServletException("Veri Tabanı Bağlantı Problemi");
			}finally {
				try {
					rs.close();
					psmt.close();
				} catch (SQLException e) {
					logger.error("PrepareStatement veya ResultSet kapatılırken hata oluştu.");
				}
			}
		}
	}

}
