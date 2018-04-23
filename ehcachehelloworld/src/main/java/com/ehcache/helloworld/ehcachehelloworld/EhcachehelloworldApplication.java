package com.ehcache.helloworld.ehcachehelloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EhcachehelloworldApplication {

	// The method below need to implement ServletContextInitializer
	// @Override
	// public void onStartup(ServletContext servletContext) throws ServletException
	// {
	// // Config Servlet
	// servletContext.addServlet("servletTest",new ServletTest())
	// .addMapping("/servletTest");
	// // Config Filter
	// servletContext.addFilter("timeFilter",new TimeFilter())
	// .addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/*");
	// // Config Listener
	// servletContext.addListener(new ListenerTest());
	// }

	public static void main(String[] args) {
		SpringApplication.run(EhcachehelloworldApplication.class, args);
	}
}
