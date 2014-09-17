package com.packs.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		System.out.println(sessionEvent.getSession().getId() + " id li oturum oluşturuldu");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		System.out.println(sessionEvent.getSession().getId() + " id li oturum silindi");		
	}

}
