package com.smart.admin.modules.dic.mapper;

import java.util.List;

import com.smart.admin.core.IBaseMapper;
import com.smart.admin.modules.dic.bean.Dic;

/**
 * 
 * @author gaowenming
 *
 */
public interface DicMapper extends IBaseMapper<Dic> {
	public List<Dic> selectByname() throws Exception;

}
