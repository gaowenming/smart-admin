package com.smart.admin.core.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smart.admin.modules.user.bean.User;

/**
 * 登陆过滤器
 * 
 * @author gaowenming
 * 
 * @date 2013-5-23 下午3:02:34
 * 
 */
public class LoginAuthenticationFilter implements Filter {

	public LoginAuthenticationFilter() {
		super();
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain filter) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;

		HttpServletResponse response = (HttpServletResponse) resp;

		String url = request.getServletPath();
		// 登入不要拦截
		if (url != null && !url.equals("") && "/login.jsp".equals(url)) {

			filter.doFilter(req, resp);

			return;
		}

		// 获取security登入信息，实现 security UserDetails的信息
		User user = null;
		try {
			user = SecurityUserHolder.getCurrentUser();
		} catch (Exception e) {
			//获取用户信息失败，说明当前用户未登陆
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
			response.sendRedirect(basePath + "login.jsp");
			return;
		}

		if (user != null) {
			// 没有转向时执行，否则会看不到页面
			filter.doFilter(req, resp);

		} else { // 为空，表示非法进入
			request.getRequestDispatcher("/login.jsp?error=true").forward(request,
					response);
			return;
		}
	}

	public void destroy() {
	}

	public void init(FilterConfig paramFilterConfig) throws ServletException {
	}

}
