package com.smart.admin.core.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * 
 * @Description: springmvc 基础controller
 * @author gaowm
 * @date 2013-9-2 下午8:45:23
 * 
 */
public abstract class BaseController<T> {

	public static String SUCCESS_MESSAGE = "操作成功";
	public static String ERROR_MESSAGE = "操作失败";

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
