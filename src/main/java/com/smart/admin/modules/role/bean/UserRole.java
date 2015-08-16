package com.smart.admin.modules.role.bean;

import java.io.Serializable;

import com.smart.admin.modules.user.bean.User;

/**
 * Description: <用户角色关联对象>. <br>
 * <p>
 * <使用说明>
 * </p>
 * Makedate:2014年6月19日 下午9:01:01
 * 
 * @author gaowenming
 * @version V1.0
 */
public class UserRole implements Serializable {

	private static final long serialVersionUID = -2031708648082745150L;
	private Integer id;

	private User user;

	private Role role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
