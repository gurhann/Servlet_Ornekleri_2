package com.packs.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
		ServletRequest servletRequest = servletRequestEvent.getServletRequest();
		System.out.println(servletRequest.getRemoteAddr() + " ip sinden oluşturulan ServletRequest sonlandı");
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent servletRequestEvent) {
		ServletRequest servletRequest = servletRequestEvent.getServletRequest();
		System.out.println(servletRequest.getRemoteAddr() + " ip sinden ServletRequest oluşturuldu");
		
	}

}
