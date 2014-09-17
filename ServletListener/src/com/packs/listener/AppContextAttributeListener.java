package com.packs.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class AppContextAttributeListener  implements ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
		System.out.println("Servlet Contexte " +  servletContextAttributeEvent.getName() + "özelliği atandı");
		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
		System.out.println("Servlet Contextden " +  servletContextAttributeEvent.getName() + "özelliği silindi");
		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
		System.out.println("Servlet Contextteki " +  servletContextAttributeEvent.getName() + "özelliği değiştirildi");
		
	}

}
