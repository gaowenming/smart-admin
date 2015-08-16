package com.smart.admin.modules.user.mapper;

import java.io.Serializable;
import java.util.List;

import com.smart.admin.core.IBaseMapper;
import com.smart.admin.modules.user.bean.User;

/**
 * 
 * @Description:
 * @Author:gaowenming
 * @Since:2015年8月15日 下午8:19:38
 */
public interface UserMapper extends IBaseMapper<User> {

	public List<User> selectByUsername(String username) throws Exception;

	public void updateUserPassword(String username, String password) throws Exception;

	public void deleteUserRole(Serializable... ids) throws Exception;

}
