package com.trickytechnos.cdb.config;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Order(1)
public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {DatabaseConfig.class};
	}
	
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {ThymeleafConfig.class,WebAppConfig.class};
	}

	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
}
