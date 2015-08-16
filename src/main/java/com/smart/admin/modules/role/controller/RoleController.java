package com.smart.admin.modules.role.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.smart.admin.modules.permission.bean.Permission;
import com.smart.admin.modules.permission.service.IPermissionService;
import com.smart.admin.modules.role.bean.Role;
import com.smart.admin.modules.role.bean.RolePermission;
import com.smart.admin.modules.role.service.IRolePermissionService;
import com.smart.admin.modules.role.service.IRoleService;
import com.smart.admin.modules.utils.SmartTree;
import com.smart.admin.modules.utils.SubSmartTree;
import com.smart.utils.JsonUtil;
import com.smart.utils.ListSortUtils;

/**
 * <p>
 * 
 * </p>
 * generate time:2014-6-15 15:49:42
 * 
 */

@Controller
public class RoleController extends BaseController<Role> {

	@Resource
	private IRoleService roleService;

	@Resource
	private IPermissionService permissionService;

	@Resource
	private IRolePermissionService rolePermissionService;

	/** binder用于bean属性的设置 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	/**
	 * 管理列表页.
	 * 
	 * @param bean
	 *            Role
	 * @param model
	 *            Model
	 * @return list.jsp
	 */
	@RequestMapping("/role/list.do")
	public String handleList(@ModelAttribute("queryBean") Role role, @ModelAttribute("_pageBean") Page page, @ModelAttribute("sorter") Sorter sorter, Model model) {
		logger.info("[RoleController:handleList][begin]");
		List<Role> results = null;
		try {
			results = roleService.findByPage(role, sorter, page);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		model.addAttribute("results", results);
		logger.info("[RoleController:handleList][end]");
		return "security/role_list";

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
	@RequestMapping("/role/toAdd.do")
	public String handleToAdd(Role role, Model model) {
		logger.info("[RoleController:handleEdit][begin]");

		model.addAttribute("dataObj", new Role());
		logger.info("[RoleController:handleEdit][end]");
		return "security/role_add";
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
	@RequestMapping("/role/toEdit.do")
	public String handleToEdit(Model model, @ModelAttribute Role role) {
		logger.info("handleToEdit");
		try {
			role = roleService.get(role.getId());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		model.addAttribute("dataObj", role);
		return "security/role_edit";
	}

	/**
	 * 新增
	 * 
	 * @param role
	 * @param model
	 * @return
	 */
	@RequestMapping("/role/add.do")
	public String handleAdd(@ModelAttribute Role role, Model model, @ModelAttribute("_pageBean") Page page, @ModelAttribute("sorter") Sorter sorter) {
		String message = SUCCESS_MESSAGE;
		try {
			logger.info("handleAdd");
			roleService.save(role);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			message = ERROR_MESSAGE;
		}
		model.addAttribute("message", message);

		return handleList(new Role(), page, sorter, model);
	}

	/**
	 * 描述 : <编辑信息>. <br>
	 * <p>
	 * <使用方法说明>
	 * </p>
	 * 
	 * @param role
	 * @param model
	 * @param page
	 * @param sorter
	 * @return
	 */
	@RequestMapping("/role/edit.do")
	public String handleEdit(@ModelAttribute Role role, Model model, @ModelAttribute("_pageBean") Page page, @ModelAttribute("sorter") Sorter sorter) {
		String message = SUCCESS_MESSAGE;
		try {
			logger.info("handleEdit");
			roleService.update(role);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			message = ERROR_MESSAGE;
		}
		model.addAttribute("message", message);

		return handleList(new Role(), page, sorter, model);
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
	@RequestMapping(value = "/role/delete.do")
	public String handleDelete(java.lang.Integer[] ids, @ModelAttribute("queryBean") Role role, @ModelAttribute("_pageBean") Page page, @ModelAttribute("sorter") Sorter sorter, Model model) {
		String message = SUCCESS_MESSAGE;
		logger.info("handleDelete");
		try {
			roleService.deleteBatch(ids);
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			message = ERROR_MESSAGE;
		}

		model.addAttribute("message", message);
		return handleList(role, page, sorter, model);
	}

	/**
	 * 描述 : <跳转到添加权限页面>
	 * 
	 * @param model
	 * @param roleId
	 * @return
	 */
	// @RequestMapping("/role/toAddPermission.do")
	// public String handleToAddPermission(Model model, Integer roleId) {
	// logger.info("handleToEdit");
	// List<Permission> list = null;
	// List<ChosenItem> listItem = new ArrayList<ChosenItem>();
	// Role roleBean = null;
	// try {
	// roleBean = roleService.get(roleId);
	// list = permissionService.findAllList();
	//
	// for (Permission permission : list) {
	// boolean b = false;
	// for (RolePermission rp : roleBean.getRolePermission()) {
	// if (permission.getId() == rp.getPermission().getId()) {
	// b = true;
	// break;
	// }
	// }
	// ChosenItem item = new ChosenItem(permission.getId().toString(),
	// permission.getPermName(), b);
	// listItem.add(item);
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// logger.error(e.getMessage());
	// }
	// model.addAttribute("dataObj", roleBean);
	// model.addAttribute("listItem", listItem);
	// return "security/role_addPermission";
	// }

	@RequestMapping("/role/toAddPermission.do")
	public String handleToAddPermission(Model model, Integer roleId) {
		logger.info("handleToEdit");
		List<Permission> list = null;

		List<SmartTree> parentListItem = new ArrayList<SmartTree>();
		Role roleBean = null;
		try {
			roleBean = roleService.get(roleId);
			list = permissionService.findAllList();

			for (Permission permission : list) {
				if (permission.getParentPermission() != null && permission.getParentPermission().getId() == 1) {
					int checkstate = 0;
					for (RolePermission rp : roleBean.getRolePermission()) {
						if (permission.getId() == rp.getPermission().getId()) {
							checkstate = 1;
							break;
						}
					}

					SmartTree parentSmartTree = new SmartTree();

					List<SubSmartTree> subListItem = new ArrayList<SubSmartTree>();
					for (Permission childPermission : permission.getSubPermissions()) {
						int childCheckstate = 0;
						for (RolePermission rp : roleBean.getRolePermission()) {
							if (childPermission.getId() == rp.getPermission().getId()) {
								childCheckstate = 1;
								break;
							}
						}
						SubSmartTree subSmartTree = new SubSmartTree();
						subSmartTree.setCheckstate(childCheckstate);
						subSmartTree.setHasChildren(childPermission.getSubPermissions().isEmpty() ? false : true);
						subSmartTree.setId(childPermission.getId().toString());
						subSmartTree.setText(childPermission.getPermName());
						subSmartTree.setValue(childPermission.getId().toString());
						subSmartTree.setComplete(true);
						subSmartTree.setIsexpand(true);
						subSmartTree.setShowcheck(true);
						subListItem.add(subSmartTree);
					}

					ListSortUtils.sort(subListItem, "id", "0");

					parentSmartTree.setCheckstate(checkstate);
					parentSmartTree.setHasChildren(permission.getSubPermissions().isEmpty() ? false : true);
					parentSmartTree.setId(permission.getId().toString());
					parentSmartTree.setText(permission.getPermName());
					parentSmartTree.setValue(permission.getId().toString());
					parentSmartTree.setComplete(true);
					parentSmartTree.setIsexpand(true);
					parentSmartTree.setShowcheck(true);
					parentSmartTree.setChildNodes(subListItem);

					parentListItem.add(parentSmartTree);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		model.addAttribute("dataObj", roleBean);
		model.addAttribute("itemJson", JsonUtil.getJsonString4ListData(parentListItem).replaceAll("childNodes", "ChildNodes"));
		return "security/role_addPermission_1";
	}

	/**
	 * 描述 : <添加权限>
	 * 
	 * @param model
	 * @param permissionIds
	 * @param roleId
	 * @param page
	 * @param sorter
	 * @return
	 */
	@RequestMapping(value = "/role/addPermission.do")
	public String handleAddPermission(Model model, Integer[] permissionIds, Integer roleId, @ModelAttribute("_pageBean") Page page, @ModelAttribute("sorter") Sorter sorter) {
		String message = SUCCESS_MESSAGE;
		logger.info("handleAddPermission");
		try {
			rolePermissionService.addRolePermission(permissionIds, roleId);

//			SecurityMetadataSourceInterceptor interceptor = SpringBeanContainer.getBean("securityMetadataSourceInterceptor");
//			// 刷新权限
//			interceptor.reloadConfigAttribute();

		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			message = ERROR_MESSAGE;
		}

		model.addAttribute("message", message);
		return handleList(new Role(), page, sorter, model);
	}
}