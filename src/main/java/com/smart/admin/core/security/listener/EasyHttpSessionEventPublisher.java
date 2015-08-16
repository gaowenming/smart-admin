package com.smart.admin.core.security.listener;

import javax.servlet.http.HttpSessionEvent;

import org.springframework.security.web.session.HttpSessionEventPublisher;

/**
 * 自定义session监听器
 * 
 * @author gaowenming
 * 
 * @date 2013-5-27 下午2:42:21
 * 
 */
public class EasyHttpSessionEventPublisher extends HttpSessionEventPublisher {
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		super.sessionCreated(event);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		super.sessionDestroyed(event);
	}
}
