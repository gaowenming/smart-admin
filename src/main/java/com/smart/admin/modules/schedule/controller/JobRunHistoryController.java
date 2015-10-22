package com.smart.admin.modules.schedule.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.smart.admin.modules.schedule.bean.JobRunHistory;
import com.smart.admin.modules.schedule.service.IJobRunHistoryService;

/**
 * <p>
 * 
 * </p>
 * generate time:2015-10-21 9:29:28
 * 
 */

@Controller
public class JobRunHistoryController extends BaseController<JobRunHistory> {

    @Autowired
    private IJobRunHistoryService jobRunHistoryService;

    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    }
    
    /**
     * 管理列表页.
     * 
     * @param bean
     *            JobRunHistory
     * @param model
     *            Model
     * @return list.jsp
     */
    @RequestMapping("/jobRunHistory/list.do")
    public String handleList(@ModelAttribute("queryBean") JobRunHistory jobRunHistory, @ModelAttribute("_pageBean") Page page, @ModelAttribute("sorter") Sorter sorter, Model model) {
        logger.info("[JobRunHistoryController:handleList][begin]");
        List<JobRunHistory> results = null;
        try {
            results = jobRunHistoryService.findByPage(jobRunHistory, sorter, page);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        model.addAttribute("results", results);
        logger.info("[JobRunHistoryController:handleList][end]");
        return "schedule/jobRunHistoryList";

    }

}
