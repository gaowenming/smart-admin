package com.smart.admin.modules.permission.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smart.admin.core.controller.BaseController;
import com.smart.admin.core.page.Page;
import com.smart.admin.core.page.Sorter;
import com.smart.admin.modules.permission.bean.Permission;
import com.smart.admin.modules.permission.service.IPermissionService;

/**
 * <p>
 * 
 * </p>
 * generate time:2014-6-15 18:42:45
 * 
 */

@Controller
public class PermissionController extends BaseController<Permission> {

	@Autowired
	private IPermissionService permissionService;

	private final static Logger logger = LoggerFactory.getLogger(PermissionController.class);

	/**
	 * 管理列表页.
	 * 
	 * @param bean
	 *            Permission
	 * @param model
	 *            Model
	 * @return list.jsp
	 */
	@RequestMapping("/permission/list.do")
	public String handleList(@ModelAttribute("queryBean") Permission permission, @ModelAttribute("_pageBean") Page page, @ModelAttribute("sorter") Sorter sorter, Model model) {
		logger.info("[PermissionController:handleList][begin]");
		List<Permission> results = null;
		try {
			results = permissionService.findByPage(permission, sorter, page);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		model.addAttribute("results", results);
		logger.info("[PermissionController:handleList][end]");
		return "/security/permission_list";

	}

	/**
	 * 
	 * 描述 : <新增/编辑页面>. <br>
	 * <p>
	 * 
	 * @param bean
	 * @param model
	 * @param sorter
	 * @return
	 */
	@RequestMapping("/permission/toAdd.do")
	public String handleToAdd(Permission permission, Model model) {
		logger.info("[PermissionController:handleEdit][begin]");

		model.addAttribute("dataObj", new Permission());
		logger.info("[PermissionController:handleEdit][end]");
		return "/security/permission_add";
	}

	/**
	 * 描述 : <跳转到编辑页面>. <br>
	 * <p>
	 * <使用方法说明>
	 * </p>
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/permission/toEdit.do")
	public String handleToEdit(Model model, @ModelAttribute Permission permission) {
		logger.info("handleToEdit");
		List<Permission> list = null;
		try {
			permission = permissionService.get(permission.getId());
			list = permissionService.findAllMenuList();
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		model.addAttribute("dataObj", permission);
		model.addAttribute("list", list);
		return "/security/permission_edit";
	}

	/**
	 * 新增
	 * 
	 * @param permission
	 * @param model
	 * @return
	 */
	@RequestMapping("/permission/add.do")
	public String handleAdd(Permission permission, RedirectAttributes attr) {
		String message = SUCCESS_MESSAGE;
		try {
			logger.info("handleAdd");
			permissionService.save(permission);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			message = ERROR_MESSAGE;
		}
		attr.addFlashAttribute("message", message);

		return "redirect:/permission/list.do";
	}

	/**
	 * 描述 : <编辑信息>. <br>
	 * <p>
	 * <使用方法说明>
	 * </p>
	 * 
	 * @param permission
	 * @param model
	 * @param page
	 * @param sorter
	 * @return
	 */
	@RequestMapping("/permission/edit.do")
	public String handleEdit(@ModelAttribute Permission permission, RedirectAttributes attr) {
		String message = SUCCESS_MESSAGE;
		try {
			logger.info("handleEdit");
			permissionService.update(permission);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			message = ERROR_MESSAGE;
		}
		attr.addFlashAttribute("message", message);

		return "redirect:/permission/list.do";
	}

	/**
	 * 删除系统配置
	 * 
	 * @param ids
	 *            id数组
	 * @param model
	 *            数据封装
	 * @return 视图名称
	 */
	@RequestMapping(value = "/permission/delete.do")
	public String handleDelete(java.lang.Integer[] ids, RedirectAttributes attr) {
		String message = SUCCESS_MESSAGE;
		logger.info("handleDelete");
		try {
			permissionService.deleteBatch(ids);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			message = ERROR_MESSAGE;
		}

		attr.addFlashAttribute("message", message);

		return "redirect:/permission/list.do";
	}

	/**
	 * 描述 : <返回获取权限>. <br>
	 * <p>
	 * <使用方法说明>
	 * </p>
	 * 
	 * @return
	 */
	@RequestMapping("/permission/findAll.do")
	@ResponseBody
	public List<Permission> handleFindAll() {
		List<Permission> list = null;
		try {
			logger.info("handleFindAll");
			list = permissionService.findAllMenuList();
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return list;
	}

}
