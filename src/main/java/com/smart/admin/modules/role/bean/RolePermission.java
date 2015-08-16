package com.smart.admin.modules.role.bean;

import java.io.Serializable;

import com.smart.admin.modules.permission.bean.Permission;

/**
 * Description: <类功能描述>. <br>
 * <p>
 * <使用说明>
 * </p>
 * Makedate:2014年6月19日 下午9:09:27
 * 
 * @author gaowenming
 * @version V1.0
 */
public class RolePermission implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8155249848907986942L;

	private Integer id;

	private Permission permission;

	private Role role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
