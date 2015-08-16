package com.smart.admin.modules.permission.service;import java.io.Serializable;import java.util.HashMap;import java.util.List;import java.util.Map;import javax.annotation.Resource;import org.apache.commons.lang3.StringUtils;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.stereotype.Service;import com.smart.admin.core.page.Page;import com.smart.admin.core.page.Sorter;import com.smart.admin.modules.permission.bean.Permission;import com.smart.admin.modules.permission.mapper.PermissionMapper;/** * <p> * </p> * generate time:2014-6-15 18:42:45 *  */@Service(value = "permissionService")public class PermissionServiceImpl implements IPermissionService {	private static final Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);	@Resource	private PermissionMapper permissionMapper;	@Override	public List<Permission> findByPage(final Permission permission, Sorter sorter, Page page) throws Exception {		Map<String, Object> map = new HashMap<String, Object>();		if (sorter == null || StringUtils.isEmpty(sorter.getSortName())) {			sorter = new Sorter();			sorter.setSortName("id");			sorter.setSortType("DESC");		}		page.setPageSize(20);		map.put("permName", permission.getPermName());		map.put("permUrl", permission.getPermUrl());		map.put("start", page.getRecordStartIndex());		map.put("pageSize", page.getPageSize());		map.put("sortField", sorter.getSortName());		map.put("sortType", sorter.getSortType());		int count = permissionMapper.count(map);		page.setTotal(count);		return permissionMapper.findPageList(map);	}	@Override	public void update(Permission permission) throws Exception {		logger.info("PermissionServiceImpl update begin");		permissionMapper.update(permission);		logger.info("PermissionServiceImpl update end");	}	@Override	public void save(Permission permission) throws Exception {		logger.info("PermissionServiceImpl add begin");		permissionMapper.save(permission);		logger.info("PermissionServiceImpl add begin");	}	@Override	public Permission get(Serializable id) throws Exception {		logger.info("PermissionServiceImpl get begin");		Permission permission = permissionMapper.get(id);		logger.info("PermissionServiceImpl get end");		return permission;	}	@Override	public void deleteBatch(Serializable... ids) throws Exception {		logger.info("PermissionServiceImpl delete begin");		permissionMapper.deleteBatch(ids);		logger.info("PermissionServiceImpl delete end");	}	@Override	public void delete(Serializable id) throws Exception {		permissionMapper.delete(id);	}	@Override	public List<Permission> findAllList() throws Exception {		return permissionMapper.findAllList();	}	@Override	public List<Permission> findAllMenuList() throws Exception {		return permissionMapper.findAllMenuList();	}}