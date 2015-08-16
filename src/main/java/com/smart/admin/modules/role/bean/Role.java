package com.smart.admin.modules.role.bean;

import java.io.Serializable;
import java.util.Set;

/**
 * Description: <Role>. <br>
 * 
 * generate time:2014-6-15 15:44:08
 * 
 */
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	private java.lang.Integer id;

	private java.lang.String name;

	private java.lang.String roleCode;

	private java.lang.String remark;

	private Set<UserRole> userRole;

	private Set<RolePermission> rolePermission;

	public java.lang.Integer getId() {
		return id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	public Set<RolePermission> getRolePermission() {
		return rolePermission;
	}

	public void setRolePermission(Set<RolePermission> rolePermission) {
		this.rolePermission = rolePermission;
	}

	public java.lang.String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(java.lang.String roleCode) {
		this.roleCode = roleCode;
	}

}
