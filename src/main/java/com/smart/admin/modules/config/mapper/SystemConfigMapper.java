package com.smart.admin.modules.config.mapper;

import java.util.List;

import com.smart.admin.core.IBaseMapper;
import com.smart.admin.modules.config.bean.SystemConfig;

/**
 * 
 * @author gaowenming
 *
 */
public interface SystemConfigMapper extends IBaseMapper<SystemConfig> {

	public List<SystemConfig> selectByKey(String configKey) throws Exception;
}
