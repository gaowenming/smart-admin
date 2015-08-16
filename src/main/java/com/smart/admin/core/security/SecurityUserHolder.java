package com.smart.admin.core.security;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;

import com.smart.admin.modules.user.bean.User;
import com.smart.utils.MD5;


/**
 * 
 * 用户帮助类
 * 
 * @author gaowenming
 * 
 * @date 2013-5-19 下午8:55:35
 * 
 */
public class SecurityUserHolder {

	public static User getCurrentUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	public static String getCurrentUserFullName() {
		return getCurrentUser().getFullname();
	}

	public static String getCurrentUserId() {
		return getCurrentUser().getId().toString();
	}

	public static String getCurrentUsername() {
		return getCurrentUser().getUsername();
	}

	/**
	 * 
	 * TODO 用户密码加密
	 * 
	 * @param passWord
	 * @param userName
	 * @return String
	 */
	public static String getSecurityPassWord(String passWord, String userName) {
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String encodedPwd = encoder.encodePassword(passWord.trim(), userName.trim());
		return encodedPwd;
	}

	/**
	 * 描述 : <MD5加密>
	 * 
	 * @param passWord
	 * @return
	 */
	public static String getSecurityPassWord(String passWord) {
		String encodedPwd = new MD5().getMD5ofStr(passWord).toLowerCase();
		return encodedPwd;
	}

}