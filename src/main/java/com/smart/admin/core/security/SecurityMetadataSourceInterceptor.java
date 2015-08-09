package com.smart.admin.core.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntUrlPathMatcher;
import org.springframework.security.web.util.RegexUrlPathMatcher;
import org.springframework.security.web.util.UrlMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 自定义权限过滤器
 * 
 * @author gaowenming
 * 
 * @date 2013-5-19 下午8:51:30
 * 
 */
@Service(value = "securityMetadataSourceInterceptor")
public class SecurityMetadataSourceInterceptor implements FilterInvocationSecurityMetadataSource, InitializingBean {

	@Resource
	private ISecurityManagerService securityManagerService;
	private static Map<String, List<ConfigAttribute>> urlMap = new HashMap<String, List<ConfigAttribute>>();
	private UrlMatcher urlMatcher;
	private boolean useAntPath = true;

	private boolean lowercaseComparisons = true;

	public void setUseAntPath(boolean useAntPath) {
		this.useAntPath = useAntPath;
	}

	public void setLowercaseComparisons(boolean lowercaseComparisons) {
		this.lowercaseComparisons = lowercaseComparisons;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.urlMatcher = new RegexUrlPathMatcher();

		if (this.useAntPath) {
			this.urlMatcher = new AntUrlPathMatcher();
		}

		if ("true".equals(Boolean.valueOf(this.lowercaseComparisons))) {
			if (!this.useAntPath) {
				((RegexUrlPathMatcher) this.urlMatcher).setRequiresLowerCaseUrl(true);
			}
		} else if (("false".equals(Boolean.valueOf(this.lowercaseComparisons))) && (this.useAntPath)) {
			((AntUrlPathMatcher) this.urlMatcher).setRequiresLowerCaseUrl(false);
		}

		initConfigAttribute(urlMap);
	}

	private void initConfigAttribute(Map<String, List<ConfigAttribute>> map) {
		Map<String, String> urlAuthorities = this.securityManagerService.loadUrlAuthorities();

		for (Map.Entry entry : urlAuthorities.entrySet()) {
			String roles = (String) entry.getValue();
			if (entry.getKey() != null) {
				map.put(entry.getKey().toString(), SecurityConfig.createList(StringUtils.commaDelimitedListToStringArray(roles)));
			}

		}
	}

	public void reloadConfigAttribute() {
		this.securityManagerService.reloadUrlAuthorities();
		Map<String, String> urlAuthorities = this.securityManagerService.loadUrlAuthorities();

		urlMap = new HashMap();
		for (Map.Entry entry : urlAuthorities.entrySet()) {
			String roles = (String) entry.getValue();
			if (entry.getKey() != null) {
				urlMap.put(entry.getKey().toString(), SecurityConfig.createList(StringUtils.commaDelimitedListToStringArray(roles)));
			}
		}
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		Map<String, String> urlAuthorities = this.securityManagerService.loadUrlAuthorities();

		List result = new ArrayList();
		for (Map.Entry entry : urlAuthorities.entrySet()) {
			String roles = (String) entry.getValue();
			result.addAll(SecurityConfig.createList(StringUtils.commaDelimitedListToStringArray(roles)));
		}

		return result;
	}

	@Override
	public List<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		String uri = ((FilterInvocation) object).getRequestUrl();
		for (Map.Entry entry : urlMap.entrySet()) {
			String url = (String) entry.getKey();
			if (this.urlMatcher.pathMatchesUrl(url, uri)) {
				return (List) entry.getValue();
			}
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}
}