package com.packs.servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(name="merhaba", urlPatterns={"/MerhabaServlet", "/deneme"})
public class GenericServletSinifi extends GenericServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		
		System.out.println(getServletConfig().getServletName() + "isimli servlet başlangıç durumuna geçti");
	}
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		
		System.out.println(getServletConfig().getServletName() + "isimli servlet Service Edildi");
		
		
	}
	
	@Override
	public void destroy() {
		
		System.out.println(getServletConfig().getServletName() + "isimli servlet siliniyor");
	}

}
