package com.smart.admin.core.config;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 解析properties文件
 * 
 * @author gaowm
 * 
 * @date 2012-6-27 下午8:05:12
 * 
 */
public class Config {

	private static Map<String, String> map = new HashMap<String, String>();

	private static final Config config = new Config();

	/**
	 * 私有的构造方法
	 */
	private Config() {
	}

	/**
	 * 单例返回实例
	 */
	public static synchronized Config getInstance() {
		return config;
	}

	/**
	 * 读取properties文件并初始化内容
	 */
	static {
		try {
			InputStream in = Config.class.getClassLoader().getResourceAsStream("/config.properties");
			Properties sysProps = new Properties();

			sysProps.load(new InputStreamReader(in, "utf-8"));

			for (Object key : sysProps.keySet()) {
				map.put((String) key, sysProps.getProperty((String) key));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 得到键值的非空值
	 * 
	 * @param key
	 * @return String
	 */
	public String getNotNullValue(String key) {
		String value = map.get(key);
		if (value == null) {
			throw new ConfigItemNotFoundException("item not found value===========================" + key);
		} else {
			return value;
		}
	}

	/**
	 * 获取int类型键值
	 * 
	 * @param key
	 * @return int
	 */
	public int getIntValue(String key) {
		return Integer.parseInt(getNotNullValue(key));
	}

	/**
	 * 获取boolean值
	 * 
	 * @param key
	 * @return boolean
	 */
	public boolean getBooleanValue(String key) {
		return Boolean.parseBoolean(getNotNullValue(key));
	}

	/**
	 * 获取long值
	 * 
	 * @param key
	 * @return long
	 */
	public long getLongValue(String key) {
		return Long.parseLong(getNotNullValue(key));
	}

	/**
	 * 获取string值
	 * 
	 * @param key
	 * @return String
	 */
	public String getStringValue(String key) {
		return getNotNullValue(key);
	}

	/**
	 * 获取boolean值，指定默认值
	 * 
	 * @param key
	 * @param defaultValue
	 * @return boolean
	 */
	public boolean getBooleanValue(String key, boolean defaultValue) {
		String value = map.get(key);
		if (value == null) {
			return defaultValue;
		} else {
			return Boolean.parseBoolean(value);
		}
	}

	/**
	 * 获取int值，指定默认值
	 * 
	 * @param key
	 * @param defaultValue
	 * @return int
	 */
	public int getIntValue(String key, int defaultValue) {
		String value = map.get(key);
		if (value == null) {
			return defaultValue;
		} else {
			return Integer.parseInt(value);
		}
	}

	/**
	 * 获取long值，指定默认值
	 * 
	 * @param key
	 * @param defaultValue
	 * @return long
	 */
	public long getLongValue(String key, long defaultValue) {
		String value = map.get(key);
		if (value == null) {
			return defaultValue;
		} else {
			return Long.parseLong(value);
		}
	}

	/**
	 * 获取string值，指定默认值
	 * 
	 * @param key
	 * @param defaultValue
	 * @return String
	 */
	public String getStringValue(String key, String defaultValue) {
		String value = map.get(key);
		if (value == null) {
			return defaultValue;
		} else {
			return value;
		}
	}

}
