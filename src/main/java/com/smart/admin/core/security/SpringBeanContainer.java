package com.smart.admin.core.security;

import org.springframework.web.context.WebApplicationContext;

/**
 * bean容器帮助类
 * 
 * @author gaowenming
 * 
 * @date 2013-5-21 下午8:58:17
 * 
 */
public  class  SpringBeanContainer {
	private static WebApplicationContext wac;

	public static void setWebApplicationContext(WebApplicationContext context) {
		wac = context;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName) {
		if ((beanName == null) || ("".equals(beanName)))
			return null;
		return (T) wac.getBean(beanName);
	}
}