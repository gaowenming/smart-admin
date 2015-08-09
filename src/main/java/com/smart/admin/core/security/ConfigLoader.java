package com.smart.admin.core.security;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 
 * 
 * @author gaowenming
 * 
 * @date 2013-5-21 下午9:01:26
 * 
 */
public class ConfigLoader implements ServletContextListener {
	public void contextDestroyed(ServletContextEvent sce) {
		destroySpring(sce.getServletContext());
	}

	public void contextInitialized(ServletContextEvent sce) {
		initSpring(sce.getServletContext());
	}

	private void initSpring(ServletContext context) {
		SpringBeanContainer.setWebApplicationContext(WebApplicationContextUtils.getRequiredWebApplicationContext(context));
	}

	private void destroySpring(ServletContext context) {
		SpringBeanContainer.setWebApplicationContext(null);
	}
}