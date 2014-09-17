package com.gurhan.listeners;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

import javax.servlet.annotation.WebListener;

import com.gurhan.util.DBConnectionManager;
@WebListener
public class AppContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent contextEvent) {
		Connection con = (Connection)contextEvent.getServletContext().getAttribute("DBConnection");
		try {
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
		ServletContext context = contextEvent.getServletContext();
		
		//veri tabanı parametrelerini al ve bağlantı olustur
		String dbURL = context.getInitParameter("dbURL");
		String dbUser = context.getInitParameter("dbUser");
		String dbPassword = context.getInitParameter("dbPassword");
		
		try{
			DBConnectionManager connectionManager = new DBConnectionManager(dbURL, dbUser, dbPassword);
			context.setAttribute("DBConnection", connectionManager.getConnection());
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//log4j ayarlarını yap
		String log4jConfig = context.getInitParameter("log4j-config");
		if (log4jConfig == null) {
			System.err.println("log4j-config init param parametresi bulunamadı");
		}else {
			String webAppPath = context.getRealPath("/");
			String log4jProp = webAppPath + log4jConfig;
			File log4JConfigFile = new File(log4jProp);
			if (log4JConfigFile.exists()) {
				System.out.println("Log4J ayarlandı");
				DOMConfigurator.configure(log4jProp);
			} else {
				System.err.println(log4jProp +" bulunamadı");
				BasicConfigurator.configure();
			} 
		}
		System.out.println("log4j ayarlandı");
	}

}
