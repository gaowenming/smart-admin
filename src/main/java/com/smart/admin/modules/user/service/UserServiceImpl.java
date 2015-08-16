package com.smart.admin.modules.user.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.admin.core.page.Page;
import com.smart.admin.core.page.Sorter;
import com.smart.admin.core.security.SecurityUserHolder;
import com.smart.admin.modules.role.bean.RolePermission;
import com.smart.admin.modules.role.bean.UserRole;
import com.smart.admin.modules.user.bean.User;
import com.smart.admin.modules.user.mapper.UserMapper;

/**
 * 
 * @author gaowenming
 * 
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public void save(User model) throws Exception {
		userMapper.save(model);
	}

	@Override
	public void update(User model) throws Exception {
		userMapper.update(model);
	}

	@Override
	public void delete(Serializable id) throws Exception {
		userMapper.delete(id);
	}

	@Override
	public User get(Serializable id) throws Exception {
		return userMapper.get(id);
	}

	@Override
	public List<User> findAllList() throws Exception {
		return userMapper.findAllList();
	}

	@Override
	public List<User> findByPage(final User userBean, Sorter sorter, Page page) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		if (sorter == null || StringUtils.isEmpty(sorter.getSortName())) {
			sorter = new Sorter();
			sorter.setSortName("id");
			sorter.setSortType("DESC");
		}
		page.setPageSize(20);

		map.put("username", userBean.getUsername());
		map.put("fullname", userBean.getFullname());
		map.put("start", page.getRecordStartIndex());
		map.put("pageSize", page.getPageSize());
		map.put("sortField", sorter.getSortName());
		map.put("sortType", sorter.getSortType());

		int count = userMapper.count(map);
		page.setTotal(count);
		return userMapper.findPageList(map);
	}

	@Override
	public void deleteBatch(Serializable... ids) throws Exception {
		userMapper.deleteBatch(ids);
		userMapper.deleteUserRole(ids);
	}

	@Override
	public User findByUsername(String username) throws Exception {
		List<User> results = userMapper.selectByUsername(username);
		if (results != null && results.size() > 0) {
			return results.get(0);
		}
		return null;
	}

	@Override
	public Set<String> findPermissionByUsername(String username) throws Exception {
		User user = this.findByUsername(username);
		if (user == null) {
			return null;
		}
		Set<String> permissionSet = new HashSet<String>();
		for (UserRole ur : user.getUserRole()) {
			Set<RolePermission> setRP = ur.getRole().getRolePermission();
			for (RolePermission rp : setRP) {
				permissionSet.add(rp.getPermission().getPermUrl());
			}
		}
		return permissionSet;
	}

	@Override
	public boolean updateUserPassword(String username, String newPassword) throws Exception {
		String md5_password = SecurityUserHolder.getSecurityPassWord(newPassword, username);
		userMapper.updateUserPassword(username, md5_password);
		return true;
	}
}
