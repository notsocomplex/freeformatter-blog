package com.freeformatter.blog.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

// By implementing WebApplicationInitializer, a servlet container compatible with the latest JEE specs
// will create a web application. We do this to replace the web.xml.
public class WebApplicationInitializer implements org.springframework.web.WebApplicationInitializer {
	
	private static final String MESSAGE_DISPATCHER_SERVLET_NAME = "dispatcher";
	
	// This is the method that gets called to 'start' the application 
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		registerListener(servletContext);
		registerDispatcherServlet(servletContext);
	}
	
	// Create a dispatcher servlet to act as a front controller and to handle incoming requests
	private void registerDispatcherServlet(final ServletContext servletContext) {

		WebApplicationContext webContext = createWebApplicationContext();
		
		// Notice that we create a MessageDispatcherServlet that behaves similarly to the
		// Spring MVC DispatcherServlet.
		DispatcherServlet messageDispatcherServlet = new DispatcherServlet(webContext);	
		
		// Register the MessageDispatcherServlet instance using the name 'dispatcher'
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
			MESSAGE_DISPATCHER_SERVLET_NAME, messageDispatcherServlet
		);
		
		// Map incoming requests from / and load on startup
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	
	}
	
	// Register the Spring listeners in the servlet-context
	private void registerListener(ServletContext servletContext) {
		servletContext.addListener(new ContextLoaderListener(createApplicationContext()));		
		servletContext.addListener(new RequestContextListener());
	}
	
	// Create a XmlWebApplicationContext instance. The spring mechanism will automatically look 
	// for the file messageDispatcher-servlet.xml that contains our web beans declaration
	private WebApplicationContext createWebApplicationContext() {
		return new XmlWebApplicationContext();
	}
	
	// Create a AnnotationConfigWebApplicationContext that takes @Configuration annotated
	// configuration class to wire the beans.
	private AnnotationConfigWebApplicationContext createApplicationContext() {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(ApplicationConfig.class);
		return context;
	}
	
	@Configuration
	@ComponentScan("com.freeformatter.blog")
	private class ApplicationConfig {
		// Add logic to create beans and other non-stereotyped classes here		
	}
	
}