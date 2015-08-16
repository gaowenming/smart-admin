package com.smart.admin.modules.config.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.smart.admin.core.page.Page;
import com.smart.admin.core.page.Sorter;
import com.smart.admin.modules.config.bean.SystemConfig;
import com.smart.admin.modules.config.mapper.SystemConfigMapper;
import com.smart.admin.modules.utils.ChosenItem;
import com.smart.admin.modules.utils.StringUtils;

/**
 * Description: <类功能描述>. <br>
 * <p>
 * <使用说明>
 * </p>
 * Makedate:2014年6月14日 下午7:58:19
 * 
 * @author gaowenming
 * @version V1.0
 */
@Service("systemConfigService")
public class SystemConfigServiceImpl implements ISystemConfigService {

	@Resource
	private SystemConfigMapper systemConfigMapper;

	@Override
	public void save(SystemConfig model) throws Exception {
		systemConfigMapper.save(model);
	}

	@Override
	public void update(SystemConfig model) throws Exception {
		systemConfigMapper.update(model);
	}

	@Override
	public void delete(Serializable id) throws Exception {
		systemConfigMapper.delete(id);
	}

	@Override
	public SystemConfig get(Serializable id) throws Exception {
		return systemConfigMapper.get(id);
	}

	@Override
	public List<SystemConfig> findAllList() throws Exception {
		return systemConfigMapper.findAllList();
	}

	@Override
	public List<SystemConfig> findByPage(SystemConfig model, Sorter sorter,
			Page page) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		if (sorter == null || StringUtils.isEmpty(sorter.getSortName())) {
			sorter = new Sorter();
			sorter.setSortName("id");
			sorter.setSortType("DESC");
		}
		page.setPageSize(20);

		map.put("name", model.getName());
		map.put("configKey", model.getConfigKey());
		map.put("start", page.getRecordStartIndex());
		map.put("pageSize", page.getPageSize());
		map.put("sortField", sorter.getSortName());
		map.put("sortType", sorter.getSortType());

		int count = systemConfigMapper.count(map);
		page.setTotal(count);
		return systemConfigMapper.findPageList(map);
	}

	@Override
	public void deleteBatch(Serializable... ids) throws Exception {
		systemConfigMapper.deleteBatch(ids);
	}

	@Override
	public List<ChosenItem> queryChosenItemByKey(String configKey)
			throws Exception {
		List<ChosenItem> listItem = new ArrayList<ChosenItem>();
		List<SystemConfig> results = systemConfigMapper.selectByKey(configKey);
		if (results != null && results.size() > 0) {
			SystemConfig config = results.get(0);
			String value = config.getConfigValue();
			String[] tmp = value.split(";");
			for (String str : tmp) {
				listItem.add(new ChosenItem(str.split("=")[0],
						str.split("=")[1], false));
			}
		}
		return listItem;
	}

	@Override
	public String queryConfigValueByKey(String configKey) throws Exception {
		List<SystemConfig> list = systemConfigMapper.selectByKey(configKey);
		if (list != null && list.size() > 0) {
			return list.get(0).getConfigValue();
		}
		return null;
	}

}
