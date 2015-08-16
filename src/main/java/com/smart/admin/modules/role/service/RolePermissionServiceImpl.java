package com.smart.admin.modules.role.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.admin.core.page.Page;
import com.smart.admin.core.page.Sorter;
import com.smart.admin.modules.role.bean.Role;
import com.smart.admin.modules.role.bean.RolePermission;
import com.smart.admin.modules.role.mapper.RolePermissionMapper;

/**
 * @Description: TODO
 * @author gaowenming
 * @date 2014年8月3日 下午2:33:50
 * 
 */
@Service("rolePermissionService")
public class RolePermissionServiceImpl implements IRolePermissionService {
	private static final Logger logger = LoggerFactory.getLogger(RolePermissionServiceImpl.class);

	@Autowired
	private RolePermissionMapper rolePermissionMapper;

	@Override
	public void save(RolePermission model) throws Exception {
		rolePermissionMapper.save(model);
	}

	@Override
	public void update(RolePermission model) throws Exception {
		rolePermissionMapper.update(model);
	}

	@Override
	public void delete(Serializable id) throws Exception {
		rolePermissionMapper.delete(id);
	}

	@Override
	public RolePermission get(Serializable id) throws Exception {
		return rolePermissionMapper.get(id);
	}

	@Override
	public List<RolePermission> findAllList() throws Exception {
		return rolePermissionMapper.findAllList();
	}

	@Override
	public List<RolePermission> findByPage(RolePermission model, Sorter sorter, Page page) throws Exception {
		return null;
	}

	@Override
	public void deleteBatch(Serializable... ids) throws Exception {
		logger.info("RolePermissionService delete begin");
		rolePermissionMapper.deleteBatch(ids);
		logger.info("RolePermissionService delete end");
	}

	@Override
	public void addRolePermission(Integer[] permissionIds, Integer roleId) throws Exception {
		// 1、删除原角色权限
		rolePermissionMapper.deleteByRole(roleId);

		if (permissionIds != null && permissionIds.length > 0) {
			for (Integer permissionId : permissionIds) {
				if (permissionId != null) {
					RolePermission rolePermission = new RolePermission();
					rolePermission.setPermissionId(permissionId);
					rolePermission.setRoleId(roleId);
					rolePermissionMapper.save(rolePermission);
				}
			}
		}
	}

	@Override
	public List<Role> queryRoleByPermission(Integer permissionId) throws Exception {
		List<Role> listRole = new ArrayList<Role>();
		List<RolePermission> list = rolePermissionMapper.selectByPermissionId(permissionId);
		for (RolePermission rp : list) {
			listRole.add(rp.getRole());
		}
		return listRole;
	}
}
