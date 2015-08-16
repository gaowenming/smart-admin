package com.smart.admin.modules.role.mapper;

import java.util.List;

import com.smart.admin.core.IBaseMapper;
import com.smart.admin.modules.role.bean.RolePermission;

public interface RolePermissionMapper extends IBaseMapper<RolePermission> {

	public List<RolePermission> selectByPermissionId(int permissionId) throws Exception;

	public List<RolePermission> selectByRoleId(int roleId) throws Exception;

	public void deleteByRole(int roleId) throws Exception;
}
