package com.packs.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter
public class ServletFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("Filtre silindi");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		
		
		String servletPath = req.getServletPath();
		System.out.println("Filter " + servletPath + " için istemci->sunucu taraflı olmak üzere çalıştı");
		filterChain.doFilter(request, response);
		System.out.println("Filter " + servletPath + " için sunucu->istemci taraflı olmak üzere çalıştı");
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println(filterConfig.getFilterName() + " başlangıç durumuna geçti");
		
		
	}

}
