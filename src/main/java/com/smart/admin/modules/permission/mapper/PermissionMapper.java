package com.smart.admin.modules.permission.mapper;

import java.io.Serializable;
import java.util.List;

import com.smart.admin.core.IBaseMapper;
import com.smart.admin.modules.permission.bean.Permission;

public interface PermissionMapper extends IBaseMapper<Permission> {

	public List<Permission> findAllMenuList() throws Exception;

	public void deleteRolePermission(Serializable... ids) throws Exception;
}
