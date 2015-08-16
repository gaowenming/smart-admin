package com.smart.admin.modules.dic.controller;

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
import com.smart.admin.modules.dic.bean.Dic;
import com.smart.admin.modules.dic.service.IDicService;

/**
 * <p>
 * 
 * </p>
 * generate time:2014-9-17 16:49:49
 * 
 */

@Controller
public class DicController extends BaseController<Dic> {

	@Resource
	protected IDicService dicService;

	/** binder用于bean属性的设置 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	/**
	 * 管理列表页.
	 * 
	 * @param bean
	 *            Dic
	 * @param model
	 *            Model
	 * @return list.jsp
	 */
	@RequestMapping("/dic/list.do")
	public String handleList(@ModelAttribute("queryBean") Dic dic,
			@ModelAttribute("_pageBean") Page page,
			@ModelAttribute("sorter") Sorter sorter, Model model) {
		logger.info("[DicController:handleList][begin]");
		List<Dic> results = null;
		try {
			results = dicService.findByPage(dic, sorter, page);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		model.addAttribute("results", results);
		logger.info("[DicController:handleList][end]");
		return "dic/dic_list";

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
	@RequestMapping("/dic/toAdd.do")
	public String handleToAdd(Dic dic, Model model) {
		logger.info("[DicController:handleEdit][begin]");

		model.addAttribute("dataObj", new Dic());
		logger.info("[DicController:handleEdit][end]");
		return "dic/dic_add";
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
	@RequestMapping("/dic/toEdit.do")
	public String handleToEdit(Model model, @ModelAttribute Dic dic) {
		logger.info("handleToEdit");
		try {
			dic = dicService.get(dic.getId());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		model.addAttribute("dataObj", dic);
		return "dic/dic_edit";
	}

	/**
	 * 新增
	 * 
	 * @param dic
	 * @param model
	 * @return
	 */
	@RequestMapping("/dic/add.do")
	public String handleAdd(@ModelAttribute Dic dic, Model model,
			@ModelAttribute("_pageBean") Page page,
			@ModelAttribute("sorter") Sorter sorter) {
		String message = SUCCESS_MESSAGE;
		try {
			logger.info("handleAdd");
			dicService.save(dic);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			message = ERROR_MESSAGE;
		}
		model.addAttribute("message", message);

		return handleList(new Dic(), page, sorter, model);
	}

	/**
	 * 描述 : <编辑信息>. <br>
	 * <p>
	 * <使用方法说明>
	 * </p>
	 * 
	 * @param dic
	 * @param model
	 * @param page
	 * @param sorter
	 * @return
	 */
	@RequestMapping("/dic/edit.do")
	public String handleEdit(@ModelAttribute Dic dic, Model model,
			@ModelAttribute("_pageBean") Page page,
			@ModelAttribute("sorter") Sorter sorter) {
		String message = SUCCESS_MESSAGE;
		try {
			logger.info("handleEdit");
			dicService.update(dic);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			message = ERROR_MESSAGE;
		}
		model.addAttribute("message", message);

		return handleList(new Dic(), page, sorter, model);
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
	@RequestMapping(value = "/dic/delete.do")
	public String handleDelete(java.lang.Integer[] ids,
			@ModelAttribute("queryBean") Dic dic,
			@ModelAttribute("_pageBean") Page page,
			@ModelAttribute("sorter") Sorter sorter, Model model) {
		String message = SUCCESS_MESSAGE;
		logger.info("handleDelete");
		try {
			dicService.deleteBatch(ids);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			message = ERROR_MESSAGE;
		}

		model.addAttribute("message", message);
		return handleList(dic, page, sorter, model);
	}

}
