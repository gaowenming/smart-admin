package com.smart.admin.core.config;

/**
 * config文件解析异常
 * 
 * @author gaowm
 * 
 * @date 2012-6-27 下午9:05:35
 * 
 */
public class ConfigItemNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * @param cause
	 */
	public ConfigItemNotFoundException(Throwable cause) {
		super(cause.getMessage(), cause);
	}

	/**
	 * @param message
	 */
	public ConfigItemNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ConfigItemNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
