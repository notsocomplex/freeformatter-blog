package com.freeformatter.blog.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.freeformatter.blog.app.ApplicationConfiguration;
import com.freeformatter.blog.web.config.WebMvcContextConfiguration;

// By implementing WebApplicationInitializer, a servlet container compatible with the latest JEE specs
// will create a web application. We do this to replace the web.xml.
public class WebApplicationInitializer implements org.springframework.web.WebApplicationInitializer {

	// The name of the dispatcher servlet, equivalent to the servlet-name in web.xml
	private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		registerListener(servletContext);
		registerDispatcherServlet(servletContext);
	}

	// Register the DispatcherServlet
	private void registerDispatcherServlet(final ServletContext servletContext) {

		// Create our WebApplicationContext using an AnnotationConfigWebApplicationContext based
		// on the the @Configuration annotated class WebMvcContextConfiguration
		WebApplicationContext dispatcherContext = createContext(WebMvcContextConfiguration.class);

		// Create an instance of the DispatcherServlet using our WebApplicationContext
		DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);

		// Register the DispatcherServlet in the ServletContext
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
			DISPATCHER_SERVLET_NAME, dispatcherServlet
		);
		
		// Load on startup and handle all mappings from /
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");

	}

	private void registerListener(ServletContext servletContext) {
		
		// Create our WebApplicationContext using an AnnotationConfigWebApplicationContext based
		// on the the @Configuration annotated class ApplicationConfiguration
		WebApplicationContext rootContext = createContext(ApplicationConfiguration.class);
		
		// The DispatcherServlet automatically detects the application context loaded by
		// a ContextLoaderListener
		servletContext.addListener(new ContextLoaderListener(rootContext));
		
		// This ServletRequestListener implementation will expose the request to the current
		// execution thead
		servletContext.addListener(new RequestContextListener());
		
	}

	private WebApplicationContext createContext(final Class<?>... annotatedClasses) {
		
		// Creates a WebApplicationContext based on @Configuration annotations
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(annotatedClasses);
		return context;
		
	}

}