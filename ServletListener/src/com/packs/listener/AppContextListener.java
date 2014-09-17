package com.packs.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.packs.db.DBConenctionManager;

public class AppContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		
		System.out.println("Uygulama Sonlandırıldı.");
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		
		ServletContext context = servletContextEvent.getServletContext();
		String url = context.getInitParameter("DBURL");
		String user = context.getInitParameter("DBUSER");
		String password = context.getInitParameter("DBPASSWORD");
		
		DBConenctionManager dbManager = new DBConenctionManager(url, user, password);
		context.setAttribute("DBManager", dbManager);
		System.out.println("Veri tabanı bağlantısı yapıldı");
		
	}

}
