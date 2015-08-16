package com.smart.admin.modules.loginlog.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.admin.core.controller.BaseController;
import com.smart.admin.core.page.Page;
import com.smart.admin.core.page.Sorter;
import com.smart.admin.modules.loginlog.bean.LoginLog;
import com.smart.admin.modules.loginlog.service.ILoginLogService;

/**
 * <p>
 * 
 * </p>
 * generate time:2014-12-13 21:20:25
 * 
 */

@Controller
public class LoginLogController extends BaseController<LoginLog> {

	@Resource
	protected ILoginLogService loginLogService;

	/** binder用于bean属性的设置 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	/**
	 * 管理列表页.
	 * 
	 * @param bean
	 *            LoginLog
	 * @param model
	 *            Model
	 * @return list.jsp
	 */
	@RequestMapping("/loginLog/list.do")
	public String handleList(@ModelAttribute("queryBean") LoginLog loginLog, @ModelAttribute("_pageBean") Page page, @ModelAttribute("sorter") Sorter sorter, Model model) {
		logger.info("[LoginLogController:handleList][begin]");
		List<LoginLog> results = null;
		try {
			results = loginLogService.findByPage(loginLog, sorter, page);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		model.addAttribute("results", results);
		logger.info("[LoginLogController:handleList][end]");
		return "syslog/loginLog_list";

	}

}
