package com.smart.admin.modules.loginlog.bean;

import java.io.Serializable;

/**
 * Description: <LoginLog>. <br>
 * 
 * generate time:2014-12-13 21:20:25
 * 
 */
public class LoginLog implements Serializable {
	private static final long serialVersionUID = 1L;

	private java.lang.Integer id;

	public java.lang.Integer getId() {
		return this.id;
	}

	public void setId(java.lang.Integer value) {
		this.id = value;
	}

	private java.lang.String username;

	public java.lang.String getUsername() {
		return this.username;
	}

	public void setUsername(java.lang.String value) {
		this.username = value;
	}

	private java.lang.String clientIp;

	public java.lang.String getClientIp() {
		return this.clientIp;
	}

	public void setClientIp(java.lang.String value) {
		this.clientIp = value;
	}

	private java.util.Date loginTime;

	public java.util.Date getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(java.util.Date value) {
		this.loginTime = value;
	}
}
