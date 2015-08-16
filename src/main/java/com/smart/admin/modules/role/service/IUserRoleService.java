package com.smart.admin.modules.role.service;

import com.smart.admin.core.IBaseService;
import com.smart.admin.modules.role.bean.UserRole;

/**
 * 
 * @Description: TODO
 * @author gaowenming
 * @date 2014年6月29日 下午5:14:39
 *
 */
public interface IUserRoleService extends IBaseService<UserRole> {

	/**
	 * 描述 : <用户添加角色>
	 * 
	 * @param roleIds
	 * @param userId
	 */
	public void addUserRole(Integer[] roleIds, Integer userId) throws Exception;
}
