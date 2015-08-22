package com.smart.admin.modules.user.controller;

import java.util.ArrayList;
import java.util.Date;
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
import com.smart.admin.core.security.SecurityUserHolder;
import com.smart.admin.modules.role.bean.Role;
import com.smart.admin.modules.role.bean.UserRole;
import com.smart.admin.modules.role.service.IRoleService;
import com.smart.admin.modules.role.service.IUserRoleService;
import com.smart.admin.modules.user.bean.User;
import com.smart.admin.modules.user.service.IUserService;
import com.smart.admin.modules.utils.ChosenItem;

/**
 * 
 * @author gaowenming
 * 
 */
@Controller
public class UserController extends BaseController<User> {

	@Autowired
	private IUserService userService;

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IUserRoleService userRoleService;

	private final static Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * 列表
	 * 
	 * @param userBean
	 * @param page
	 * @param sorter
	 * @param model
	 * @return
	 */
	@RequestMapping("/user/list.do")
	public String handleList(@ModelAttribute("queryBean") User userBean, @ModelAttribute("_pageBean") Page page, @ModelAttribute("sorter") Sorter sorter, Model model) {
		List<User> results = null;
		logger.info("handleList");
		try {
			results = userService.findByPage(userBean, sorter, page);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		model.addAttribute("results", results);
		return "security/user_list";
	}

	/**
	 * 描述 : <跳转到新增页面>. <br>
	 * <p>
	 * <使用方法说明>
	 * </p>
	 * 
	 * @return
	 */
	@RequestMapping("/user/toAdd.do")
	public String handleToAdd(Model model) {
		logger.info("handleToAdd");
		model.addAttribute("dataObj", new User());
		return "security/user_add";
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
	@RequestMapping("/user/toEdit.do")
	public String handleToEdit(Model model, @ModelAttribute User userBean) {
		logger.info("handleToEdit");
		try {
			userBean = userService.get(userBean.getId());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		model.addAttribute("dataObj", userBean);
		return "security/user_edit";
	}

	/**
	 * 新增
	 * 
	 * @param userBean
	 * @param model
	 * @return
	 */
	@RequestMapping("/user/add.do")
	public String handleAdd(@ModelAttribute User userBean, RedirectAttributes attr) {
		String message = SUCCESS_MESSAGE;
		try {
			logger.info("handleAdd");
			String md_password = SecurityUserHolder.getSecurityPassWord(userBean.getPassword(), userBean.getUsername());
			userBean.setPassword(md_password);
			userBean.setCreateTime(new Date());
			userBean.setStatus(User.USER_STATUS_ENABLE);
			userService.save(userBean);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			message = ERROR_MESSAGE;
		}
		attr.addFlashAttribute("message", message);

		return "redirect:/user/list.do";
	}

	/**
	 * 描述 : <编辑信息>. <br>
	 * <p>
	 * <使用方法说明>
	 * </p>
	 * 
	 * @param userBean
	 * @param model
	 * @param page
	 * @param sorter
	 * @return
	 */
	@RequestMapping("/user/edit.do")
	public String handleEdit(@ModelAttribute User userBean, RedirectAttributes attr) {
		String message = SUCCESS_MESSAGE;
		try {
			User temp = userService.get(userBean.getId());
			logger.info("handleEdit");
			userBean.setCreateTime(temp.getCreateTime());
			userBean.setStatus(temp.getStatus());
			userBean.setPassword(temp.getPassword());
			userService.update(userBean);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			message = ERROR_MESSAGE;
		}
		attr.addFlashAttribute("message", message);

		return "redirect:/user/list.do";
	}

	/**
	 * 描述 : <停启用>. <br>
	 * <p>
	 * <使用方法说明>
	 * </p>
	 * 
	 * @param id
	 * @param model
	 * @param page
	 * @param sorter
	 * @return
	 */
	@RequestMapping("/user/changeStatus.do")
	public String handleChangeStatus(@ModelAttribute("id") Integer id, RedirectAttributes attr) {
		String message = SUCCESS_MESSAGE;
		try {
			User userBean = userService.get(id);
			logger.info("handleChangeStatus");
			if (userBean.getStatus() == User.USER_STATUS_DISABLE) {
				userBean.setStatus(User.USER_STATUS_ENABLE);
			} else {
				userBean.setStatus(User.USER_STATUS_DISABLE);
			}

			userService.update(userBean);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			message = ERROR_MESSAGE;
		}
		attr.addFlashAttribute("message", message);

		return "redirect:/user/list.do";
	}

	/**
	 * 删除用户
	 * 
	 * @param ids
	 *            id数组
	 * @param model
	 *            数据封装
	 * @return 视图名称
	 */
	@RequestMapping(value = "/user/delete.do")
	public String handleDelete(Integer[] ids, RedirectAttributes attr) {
		String message = SUCCESS_MESSAGE;
		logger.info("handleDelete");
		try {
			userService.deleteBatch(ids);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			message = ERROR_MESSAGE;
		}

		attr.addFlashAttribute("message", message);

		return "redirect:/user/list.do";
	}

	/**
	 * 
	 * 描述 : <>
	 * 
	 * @param model
	 * @param userBean
	 * @return
	 */
	@RequestMapping("/user/toAddRole.do")
	public String handleToAddRole(Model model, Integer userId) {
		logger.info("handleToEdit");
		List<Role> list = null;
		List<ChosenItem> listItem = new ArrayList<ChosenItem>();
		User userBean = null;
		try {
			userBean = userService.get(userId);
			list = roleService.findAllList();

			for (Role role : list) {
				boolean b = false;
				if (userBean.getUserRole() != null) {
					for (UserRole userRole : userBean.getUserRole()) {
						if (role.getId() == userRole.getRole().getId()) {
							b = true;
							break;
						}
					}
				}
				ChosenItem item = new ChosenItem(role.getId().toString(), role.getName(), b);
				listItem.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		model.addAttribute("dataObj", userBean);
		model.addAttribute("listItem", listItem);
		return "security/user_addRole";
	}

	/**
	 * 描述 : <添加角色>
	 * 
	 * @param model
	 * @param roleIds
	 *            角色ID
	 * @param userBean
	 * @return
	 */
	@RequestMapping(value = "/user/addRole.do")
	public String handleAddRole(Model model, Integer[] roleIds, Integer userId, RedirectAttributes attr) {
		String message = SUCCESS_MESSAGE;
		logger.info("handleAddRole");
		try {
			userRoleService.addUserRole(roleIds, userId);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			message = ERROR_MESSAGE;
		}

		attr.addFlashAttribute("message", message);

		return "redirect:/user/list.do";
	}

	/**
	 * 修改密码
	 * 
	 * @param oldPassword
	 *            原密码
	 * @param newPassword
	 *            新密码
	 * @param newPasswordConfig
	 *            新密码确认
	 * @return
	 */
	@RequestMapping(value = "/user/changePassword.do")
	@ResponseBody
	public String handleChangePassword(String oldPassword, String newPassword) {
		String message = "";
		logger.info("handleChangePassword");
		User user = SecurityUserHolder.getCurrentUser();
		String md5Password = SecurityUserHolder.getSecurityPassWord(oldPassword, user.getUsername());
		if (!user.getPassword().equals(md5Password)) {
			message = "原密码错误!";
		} else {
			try {
				userService.updateUserPassword(user.getUsername(), newPassword);
				message = "ok";
			} catch (Exception e) {
				message = "操作失败： " + e.getMessage();
				logger.error(e.getMessage());
				e.printStackTrace();
			}
		}
		return message;
	}
}
