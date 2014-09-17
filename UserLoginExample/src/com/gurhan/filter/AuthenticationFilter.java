package com.gurhan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
@WebFilter
public class AuthenticationFilter implements Filter{
	private Logger logger = Logger.getLogger(AuthenticationFilter.class);
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
			HttpServletRequest req = (HttpServletRequest)request;
			HttpServletResponse resp = (HttpServletResponse)response;
			
			String uri = req.getRequestURI();
			logger.info("İstek Kaynağı::" + uri);
			
			HttpSession session = req.getSession(false);
			if (session == null) {
				logger.error("Yetkisiz erişim isteği");
				resp.sendRedirect("login.html");
			} else {
				filterChain.doFilter(request, response);
			}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		logger.info("Authentication Filter Başlangıç Durumuna Geçti");
	}

}
