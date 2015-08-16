package com.smart.admin.modules.role.service;import java.io.Serializable;import java.util.HashMap;import java.util.List;import java.util.Map;import org.apache.commons.lang3.StringUtils;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import com.smart.admin.core.page.Page;import com.smart.admin.core.page.Sorter;import com.smart.admin.modules.role.bean.Role;import com.smart.admin.modules.role.mapper.RoleMapper;/** * <p> * </p> * generate time:2014-6-15 15:44:08 *  */@Service(value = "roleService")public class RoleServiceImpl implements IRoleService {	@Autowired	private RoleMapper roleMapper;	@Override	public List<Role> findByPage(final Role role, Sorter sorter, Page page) throws Exception {		Map<String, Object> map = new HashMap<String, Object>();		if (sorter == null || StringUtils.isEmpty(sorter.getSortName())) {			sorter = new Sorter();			sorter.setSortName("id");			sorter.setSortType("DESC");		}		page.setPageSize(20);		map.put("name", role.getName());		map.put("start", page.getRecordStartIndex());		map.put("pageSize", page.getPageSize());		map.put("sortField", sorter.getSortName());		map.put("sortType", sorter.getSortType());		int count = roleMapper.count(map);		page.setTotal(count);		return roleMapper.findPageList(map);	}	@Override	public void update(Role role) throws Exception {		roleMapper.update(role);	}	@Override	public void save(Role role) throws Exception {		roleMapper.save(role);	}	@Override	public Role get(Serializable id) throws Exception {		return roleMapper.get(id);	}	@Override	public void deleteBatch(Serializable... ids) throws Exception {		roleMapper.deleteBatch(ids);		roleMapper.deleteRoleOfUser(ids);		roleMapper.deleteRolePermission(ids);	}	@Override	public void delete(Serializable id) throws Exception {		roleMapper.delete(id);	}	@Override	public List<Role> findAllList() throws Exception {		return roleMapper.findAllList();	}}