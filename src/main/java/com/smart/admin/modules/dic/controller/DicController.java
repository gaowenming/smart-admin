package com.smart.admin.modules.dic.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@Autowired
	protected IDicService dicService;

	private final static Logger logger = LoggerFactory.getLogger(DicController.class);

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
	public String handleList(@ModelAttribute("queryBean") Dic dic, @ModelAttribute("_pageBean") Page page, @ModelAttribute("sorter") Sorter sorter, Model model) {
		logger.info("[DicController:handleList][begin]");
		List<Dic> results = null;
		try {
			results = dicService.findByPage(dic, sorter, page);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
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
			logger.error(e.getMessage(),e);
		}
		model.addAttribute("dataObj", dic);
		return "dic/dic_edit";
	}

	/**
	 * 新增
	 * 
	 * @param dic
	 * @return
	 */
	@RequestMapping("/dic/add.do")
	public String handleAdd(@ModelAttribute Dic dic, RedirectAttributes attr) {
		String message = SUCCESS_MESSAGE;
		try {
			logger.info("handleAdd");
			dicService.save(dic);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			message = ERROR_MESSAGE;
		}
		attr.addFlashAttribute("message", message);

		return "redirect:/dic/list.do";
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
	public String handleEdit(@ModelAttribute Dic dic, RedirectAttributes attr) {
		String message = SUCCESS_MESSAGE;
		try {
			logger.info("handleEdit");
			dicService.update(dic);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			message = ERROR_MESSAGE;
		}
		attr.addFlashAttribute("message", message);

		return "redirect:/dic/list.do";
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
	public String handleDelete(java.lang.Integer[] ids, RedirectAttributes attr) {
		String message = SUCCESS_MESSAGE;
		logger.info("handleDelete");
		try {
			dicService.deleteBatch(ids);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			message = ERROR_MESSAGE;
		}

		attr.addFlashAttribute("message", message);

		return "redirect:/dic/list.do";
	}

}
