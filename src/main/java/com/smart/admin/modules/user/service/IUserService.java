package com.smart.admin.modules.user.service;

import java.util.Set;

import com.smart.admin.core.IBaseService;
import com.smart.admin.modules.user.bean.User;

/**
 * 
 * @author gaowenming
 * 
 */
public interface IUserService extends IBaseService<User> {

	/**
	 * 根据用户名查询
	 * 
	 * @param username
	 *            用户名
	 * @return
	 * @throws Exception
	 */
	public User findByUsername(String username) throws Exception;

	/**
	 * 描述 : <根据用户名查询用户的权限>
	 * 
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public Set<String> findPermissionByUsername(String username) throws Exception;

	/**
	 * 修改密码
	 * 
	 * @param username
	 *            用户名
	 * @param newPassword
	 *            新密码
	 * @return
	 * @throws Exception
	 */
	public boolean updateUserPassword(String username, String newPassword) throws Exception;
}
