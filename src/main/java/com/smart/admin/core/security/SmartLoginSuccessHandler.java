package com.smart.admin.core.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.smart.admin.modules.loginlog.bean.LoginLog;
import com.smart.admin.modules.loginlog.service.ILoginLogService;

/**
 * Description: <类功能描述>. <br>
 * <p>
 * <使用说明>
 * </p>
 * Makedate:2014年12月13日 下午8:52:30
 * 
 * @author gaowenming
 * @version V1.0
 */
public class SmartLoginSuccessHandler implements AuthenticationSuccessHandler, InitializingBean {
	private Logger logger = LoggerFactory.getLogger(SmartLoginSuccessHandler.class);
	private String defaultTargetUrl;
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@Autowired
	private ILoginLogService loginLogService;

	@Override
	public void afterPropertiesSet() throws Exception {
		if (StringUtils.isEmpty(defaultTargetUrl))
			throw new Exception("You must configure defaultTargetUrl");

	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		logger.info("Login success,Forwarding to " + this.defaultTargetUrl);
		saveLoginInfo(request, authentication);
		this.redirectStrategy.sendRedirect(request, response, this.defaultTargetUrl);

	}

	public void saveLoginInfo(HttpServletRequest request, Authentication authentication) {
		try {
			String ip = this.getIpAddress(request);
			Date date = new Date();
			LoginLog log = new LoginLog();
			log.setClientIp(ip);
			log.setLoginTime(date);
			log.setUsername(authentication.getName());
			loginLogService.save(log);
		} catch (Exception e) {
			if (logger.isWarnEnabled()) {
				logger.info("无法更新用户登录信息至数据库");
			}
		}
	}

	public String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public String getDefaultTargetUrl() {
		return defaultTargetUrl;
	}

	public void setDefaultTargetUrl(String defaultTargetUrl) {
		this.defaultTargetUrl = defaultTargetUrl;
	}

}
