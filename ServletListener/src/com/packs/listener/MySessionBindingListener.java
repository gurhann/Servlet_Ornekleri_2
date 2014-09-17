package com.packs.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class MySessionBindingListener implements HttpSessionBindingListener{

	@Override
	public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out.println(httpSessionBindingEvent.getSession().getId() + " oturumuna " + httpSessionBindingEvent.getValue().toString() + " atandı");
		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out.println(httpSessionBindingEvent.getSession().getId() + " oturumundan " + httpSessionBindingEvent.getValue().toString() + " silindi");

		
	}

}
