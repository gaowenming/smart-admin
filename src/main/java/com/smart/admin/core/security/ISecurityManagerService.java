package com.smart.admin.core.security;

import java.util.Map;

/**
 * 
 * 
 * @author gaowenming
 * 
 * @date 2013-5-19 下午8:51:34
 * 
 */
public interface ISecurityManagerService {
	public abstract Map<String, String> loadUrlAuthorities();

	public abstract void reloadUrlAuthorities();
}
