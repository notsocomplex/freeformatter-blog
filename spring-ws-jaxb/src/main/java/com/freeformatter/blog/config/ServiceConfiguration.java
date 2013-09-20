package com.freeformatter.blog.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.freeformatter.blog")
public class ServiceConfiguration {
	// Just scan for stereotypes, @Service in our case
}
