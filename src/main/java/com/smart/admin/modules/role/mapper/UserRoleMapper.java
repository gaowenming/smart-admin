package com.smart.admin.modules.role.mapper;

import java.util.List;

import com.smart.admin.core.IBaseMapper;
import com.smart.admin.modules.role.bean.UserRole;

/**
 * 
 * @Description:
 * @Author:gaowenming
 * @Since:2015年8月15日 下午9:23:00
 */
public interface UserRoleMapper extends IBaseMapper<UserRole> {
	public List<UserRole> selectByUserId(int userId) throws Exception;
}
