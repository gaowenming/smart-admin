package com.smart.admin.modules.role.service;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.admin.core.page.Page;
import com.smart.admin.core.page.Sorter;
import com.smart.admin.modules.role.bean.UserRole;
import com.smart.admin.modules.role.mapper.UserRoleMapper;

/**
 * 
 * @Description: TODO
 * @author gaowenming
 * @date 2014年6月29日 下午5:15:01
 *
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements IUserRoleService {

	private static final Logger logger = LoggerFactory.getLogger(UserRoleServiceImpl.class);

	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public void save(UserRole model) throws Exception {
		userRoleMapper.save(model);
	}

	@Override
	public void update(UserRole model) throws Exception {
		userRoleMapper.update(model);
	}

	@Override
	public void delete(Serializable id) throws Exception {
		userRoleMapper.delete(id);
	}

	@Override
	public UserRole get(Serializable id) throws Exception {
		return userRoleMapper.get(id);
	}

	@Override
	public List<UserRole> findAllList() throws Exception {
		return userRoleMapper.findAllList();
	}

	@Override
	public List<UserRole> findByPage(UserRole model, Sorter sorter, Page page) throws Exception {
		return null;
	}

	@Override
	public void deleteBatch(Serializable... ids) throws Exception {
		logger.info("UserRoleServiceImpl delete begin");
		userRoleMapper.deleteBatch(ids);
		logger.info("UserRoleServiceImpl delete end");
	}

	@Override
	public void addUserRole(Integer[] roleIds, Integer userId) throws Exception {

		// 1、删除原用户的角色
		userRoleMapper.deleteByUser(userId);

		if (roleIds != null && roleIds.length > 0) {
			for (Integer roleId : roleIds) {
				UserRole userRole = new UserRole();
				userRole.setRoleId(roleId);
				userRole.setUserId(userId);
				userRoleMapper.save(userRole);
			}
		}

	}
}
