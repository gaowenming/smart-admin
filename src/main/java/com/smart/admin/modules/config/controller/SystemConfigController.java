package com.smart.admin.modules.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smart.admin.core.controller.BaseController;
import com.smart.admin.core.page.Page;
import com.smart.admin.core.page.Sorter;
import com.smart.admin.modules.config.bean.SystemConfig;
import com.smart.admin.modules.config.service.ISystemConfigService;

/**
 * Description: <类功能描述>. <br>
 * <p>
 * <使用说明>
 * </p>
 * Makedate:2014年6月14日 下午7:56:08
 * 
 * @author gaowenming
 * @version V1.0
 */
@Controller
public class SystemConfigController extends BaseController<SystemConfig> {
    @Autowired
    private ISystemConfigService systemConfigService;

    /**
     * 列表
     * 
     * @param systemConfigBean
     * @param page
     * @param sorter
     * @param model
     * @return
     */
    @RequestMapping("/systemConfig/list.do")
    public String handleList(@ModelAttribute("queryBean") SystemConfig systemConfigBean, @ModelAttribute("_pageBean") Page page, @ModelAttribute("sorter") Sorter sorter, Model model) {
        List<SystemConfig> results = null;
        logger.info("handleList");
        try {
            results = systemConfigService.findByPage(systemConfigBean, sorter, page);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        model.addAttribute("results", results);
        return "security/systemConfig_list";
    }

    /**
     * 描述 : <跳转到新增页面>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     * 
     * @return
     */
    @RequestMapping("/systemConfig/toAdd.do")
    public String handleToAdd(Model model) {
        logger.info("handleToAdd");
        model.addAttribute("dataObj", new SystemConfig());
        return "security/systemConfig_add";
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
    @RequestMapping("/systemConfig/toEdit.do")
    public String handleToEdit(Model model, @ModelAttribute SystemConfig systemConfigBean) {
        logger.info("handleToEdit");
        try {
            systemConfigBean = systemConfigService.get(systemConfigBean.getId());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        model.addAttribute("dataObj", systemConfigBean);
        return "security/systemConfig_edit";
    }

    /**
     * 新增
     * 
     * @param systemConfigBean
     * @param model
     * @return
     */
    @RequestMapping("/systemConfig/add.do")
    public String handleAdd(@ModelAttribute SystemConfig systemConfigBean, RedirectAttributes attr) {
        String message = SUCCESS_MESSAGE;
        try {
            logger.info("handleAdd");
            systemConfigService.save(systemConfigBean);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            message = ERROR_MESSAGE;
        }
        attr.addFlashAttribute("message", message);

        return "redirect:/systemConfig/list.do";
    }

    /**
     * 描述 : <编辑信息>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     * 
     * @param systemConfigBean
     * @param model
     * @param page
     * @param sorter
     * @return
     */
    @RequestMapping("/systemConfig/edit.do")
    public String handleEdit(@ModelAttribute SystemConfig systemConfigBean, RedirectAttributes attr) {
        String message = SUCCESS_MESSAGE;
        try {
            logger.info("handleEdit");
            systemConfigService.update(systemConfigBean);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            message = ERROR_MESSAGE;
        }
        attr.addFlashAttribute("message", message);

        return "redirect:/systemConfig/list.do";
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
    @RequestMapping(value = "/systemConfig/delete.do")
    public String handleDelete(Integer[] ids, RedirectAttributes attr) {
        String message = SUCCESS_MESSAGE;
        logger.info("handleDelete");
        try {
            systemConfigService.deleteBatch(ids);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            message = ERROR_MESSAGE;
        }

        attr.addFlashAttribute("message", message);
        return "redirect:/systemConfig/list.do";
    }
}
