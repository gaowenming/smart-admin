package com.smart.admin.modules.config.bean;

import java.io.Serializable;

/**
 * Description: <系统配置>. <br>
 * <p>
 * <使用说明>
 * </p>
 * Makedate:2014年6月14日 下午6:37:41
 * 
 * @author gaowenming
 * @version V1.0
 */
public class SystemConfig implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	// 名称
	private String name;
	// key
	private String configKey;
	// 值 value
	private String configValue;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getConfigKey() {
		return configKey;
	}

	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

}
