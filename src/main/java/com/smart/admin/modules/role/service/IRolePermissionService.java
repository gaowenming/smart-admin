package com.smart.admin.modules.role.service;

import java.util.List;

import com.smart.admin.core.IBaseService;
import com.smart.admin.modules.role.bean.Role;
import com.smart.admin.modules.role.bean.RolePermission;

/**
 * 
 * @Description: 角色和权限关联
 * @author gaowenming
 * @date 2014年8月3日 上午9:16:42
 *
 */
public interface IRolePermissionService extends IBaseService<RolePermission> {
	/**
	 * 描述 : <角色添加权限>
	 * 
	 * @param permissionIds
	 *            权限ID
	 * @param roleId
	 *            角色ID
	 * @throws Exception
	 */
	public void addRolePermission(Integer[] permissionIds, Integer roleId) throws Exception;

	/**
	 * 描述 : <根基权限查询所有角色>
	 * 
	 * @param permissionId
	 * @return
	 * @throws Exception
	 */
	public List<Role> queryRoleByPermission(Integer permissionId) throws Exception;
}
