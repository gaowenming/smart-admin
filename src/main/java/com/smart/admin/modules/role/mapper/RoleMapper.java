package com.smart.admin.modules.role.mapper;

import java.io.Serializable;

import com.smart.admin.core.IBaseMapper;
import com.smart.admin.modules.role.bean.Role;

/**
 * 
 * @Description:
 * @Author:gaowenming
 * @Since:2015年8月15日 下午8:45:34
 */
public interface RoleMapper extends IBaseMapper<Role> {

	public void deleteRoleOfUser(Serializable... ids) throws Exception;

	public void deleteRolePermission(Serializable... ids) throws Exception;

}
