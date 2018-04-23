package com.ehcache.helloworld.ehcachehelloworld.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class EHCacheHelloWorldListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("init servlet listener...");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//TODO
	}
}
