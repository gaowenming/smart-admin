package com.smart.admin.modules.config.service;

import java.util.List;

import com.smart.admin.core.IBaseService;
import com.smart.admin.modules.config.bean.SystemConfig;
import com.smart.admin.modules.utils.ChosenItem;

/**
 * Description: <类功能描述>. <br>
 * <p>
 * <使用说明>
 * </p>
 * Makedate:2014年6月14日 下午7:57:11
 * 
 * @author gaowenming
 * @version V1.0
 */
public interface ISystemConfigService extends IBaseService<SystemConfig> {

	/**
	 * 描述 : <查询配置项的下拉选择>
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public List<ChosenItem> queryChosenItemByKey(String key) throws Exception;

	/**
	 * 描述 : <>
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public String queryConfigValueByKey(String key) throws Exception;
}
