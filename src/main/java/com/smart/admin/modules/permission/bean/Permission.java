package com.smart.admin.modules.permission.bean;

import java.io.Serializable;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.smart.admin.modules.role.bean.RolePermission;

/**
 * Description: <Permission>. <br>
 * 
 * generate time:2014-6-15 18:42:45
 * 
 */
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final int URL = 1; // 普通链接
	public static final int MENU = 2;// 导航

	private java.lang.Integer id;

	private java.lang.String permName;

	private java.lang.String permUrl;

	private java.lang.Integer permOrder;

	private java.lang.Integer permType;

	private java.lang.String remark;

	@JsonIgnore
	private Permission parentPermission;

	@JsonIgnore
	private Set<Permission> subPermissions;

	@JsonIgnore
	private Set<RolePermission> rolePermission;

	public java.lang.Integer getId() {
		return id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.String getPermName() {
		return permName;
	}

	public void setPermName(java.lang.String permName) {
		this.permName = permName;
	}

	public java.lang.String getPermUrl() {
		return permUrl;
	}

	public void setPermUrl(java.lang.String permUrl) {
		this.permUrl = permUrl;
	}

	public java.lang.Integer getPermOrder() {
		return permOrder;
	}

	public void setPermOrder(java.lang.Integer permOrder) {
		this.permOrder = permOrder;
	}

	public java.lang.Integer getPermType() {
		return permType;
	}

	public void setPermType(java.lang.Integer permType) {
		this.permType = permType;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public Set<RolePermission> getRolePermission() {
		return rolePermission;
	}

	public void setRolePermission(Set<RolePermission> rolePermission) {
		this.rolePermission = rolePermission;
	}

	public Permission getParentPermission() {
		return parentPermission;
	}

	public void setParentPermission(Permission parentPermission) {
		this.parentPermission = parentPermission;
	}

	public Set<Permission> getSubPermissions() {
		return subPermissions;
	}

	public void setSubPermissions(Set<Permission> subPermissions) {
		this.subPermissions = subPermissions;
	}

}
