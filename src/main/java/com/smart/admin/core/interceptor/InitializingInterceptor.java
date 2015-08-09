package com.smart.admin.core.interceptor;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.smart.admin.core.security.SecurityUserHolder;

/**
 * 
 * @author gaowenming
 * 
 */
public class InitializingInterceptor extends HandlerInterceptorAdapter {
	/**
	 * 控制台日志
	 */
	protected static Logger logger = LoggerFactory.getLogger(InitializingInterceptor.class) ;

	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		// log追加：用户名 - sessionID - IP - URL - 请求参数
		StringBuffer log = new StringBuffer();
		log.append(" - ").append(SecurityUserHolder.getCurrentUsername());
		log.append(" - ").append(request.getRemoteAddr());
		log.append(" - ").append(request.getServletPath());
		if (request.getQueryString() != null) {
			log.append(" - ").append(request.getQueryString()).append(" - ");
		} else {
			Map<String, String[]> parameters = request.getParameterMap();
			if (parameters.size() != 0) {
				log.append(" - [");
			}
			for (Map.Entry<String, String[]> entry : parameters.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();
				String message = "";
				if (value.getClass().isArray()) {
					Object[] args = (Object[]) value;
					message = " " + key + "=" + Arrays.toString(args) + " ";
				} else {
					message = key + "=" + (String) value + " ";
				}
				log.append(message);
			}
			if (parameters.size() != 0) {
				log.append("]");
			}
		}
		logger.info(log.toString());

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		String _contextPath = getWebRoot(request);
		request.setAttribute("_contextPath", _contextPath);
		// request.setAttribute("_userName", userName.getUserName());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

	/**
	 * 获取web项目根路径
	 * 
	 * @return
	 */
	protected static String getWebRoot(HttpServletRequest request) {
		// 得到协议如：http
		String scheme = request.getScheme();
		// 得到服务器名称如：127.0.0.1
		String serverName = request.getServerName();
		// 得到端口号如8080
		int serverPort = request.getServerPort();
		// 得到当前上下文路径，也就是安装后的文件夹位置。
		String contextPath = request.getContextPath();
		// 连起来拼成完整的url
		String webRoot = scheme + "://" + serverName + ":" + serverPort + contextPath + "/";
		return webRoot;
	}

}
