package com.smart.admin.core.security;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.smart.meeting.modules.permission.bean.Permission;
import org.smart.meeting.modules.permission.service.IPermissionService;
import org.smart.meeting.modules.role.bean.Role;
import org.smart.meeting.modules.role.service.IRolePermissionService;
import org.smart.meeting.modules.user.bean.User;
import org.smart.meeting.modules.user.service.IUserService;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 
 * 
 * @author gaowenming
 * 
 * @date 2013-5-19 下午8:51:39
 * 
 */
@Service(value = "securityManagerService")
public class SecurityManagerServiceImpl implements ISecurityManagerService, UserDetailsService {
	@Resource
	private IUserService userService;
	@Resource
	private IPermissionService permissionService;
	@Resource
	private IRolePermissionService rolePermissionService;

	private static final Map<String, String> urlAuthorities = new HashMap<String, String>();

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		User securityUser = null;
		try {
			securityUser = this.userService.findByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (securityUser == null)
			throw new UsernameNotFoundException("未找到用户： " + username);
		return securityUser;
	}

	public Map<String, String> loadUrlAuthorities() {
		List<Permission> resources = null;
		try {
			resources = this.permissionService.findAllList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (resources.isEmpty())
			return urlAuthorities;
		for (Permission perm : resources) {
			String url = perm.getPermUrl();
			List<Role> roles = null;
			try {
				roles = rolePermissionService.queryRoleByPermission(perm.getId());
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (!roles.isEmpty()) {
				StringBuffer sb = new StringBuffer();
				for (Role rr : roles) {
					sb.append(rr.getRole_code());
					sb.append(",");
				}
				urlAuthorities.put(url, sb.substring(0, sb.length() - 1));
			}
		}
		return urlAuthorities;
	}

	public void reloadUrlAuthorities() {
		urlAuthorities.clear();
		loadUrlAuthorities();
	}

}