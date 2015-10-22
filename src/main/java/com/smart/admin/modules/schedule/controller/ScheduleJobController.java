package com.smart.admin.modules.schedule.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.quartz.CronExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smart.admin.core.controller.BaseController;
import com.smart.admin.core.page.Page;
import com.smart.admin.modules.schedule.bean.ScheduleJob;
import com.smart.admin.modules.schedule.service.ScheduleJobService;

/**
 * 
 * @Description 
 * @author gaowenming
 */
@Controller
@RequestMapping("/schedule")
public class ScheduleJobController extends BaseController<ScheduleJob> {

    private final static String TASK_GROUP = "smart_group";

    @Autowired
    private ScheduleJobService scheduleJobService;

    /**
     * 默认页面
     * 
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String list() {
        return "schedule/jobList";
    }

    /**
     * 获取所有任务列表
     */
    @RequestMapping("/list.do")
    public String getAllJobs(Model model, @ModelAttribute("_pageBean") Page page) {
        logger.info("getAllJobs");
        List<ScheduleJob> scheduleJobs = scheduleJobService.getAllScheduleJob();
        page.setPageSize(100);
        page.setTotal(scheduleJobs.size());
        model.addAttribute("results", scheduleJobs);
        return "schedule/jobList";
    }

    /**
     * 获取所有运行中任务列表
     */
    @RequestMapping("/listRunning.do")
    public String getAllRunningJobs(Model model, @ModelAttribute("_pageBean") Page page) {
        logger.info("getAllJobs");
        List<ScheduleJob> scheduleJobs = scheduleJobService.getAllRuningScheduleJob();
        page.setPageSize(100);
        page.setTotal(scheduleJobs.size());
        model.addAttribute("results", scheduleJobs);
        return "schedule/jobRunningList";
    }

    /**
     * 添加跳转
     * @param model
     */
    @RequestMapping("/add.do")
    public String createForm() {
        return "schedule/jobAdd";
    }

    /**
     * 添加
     * @param user
     * @param model
     */
    @RequestMapping("/save.do")
    public String create(ScheduleJob scheduleJob, RedirectAttributes attr) {
        scheduleJob.setStatus("1");
        scheduleJob.setGroup(TASK_GROUP);
        String message = SUCCESS_MESSAGE;
        try {
            scheduleJobService.add(scheduleJob);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            message = ERROR_MESSAGE;
        }

        attr.addFlashAttribute("message", message);

        return "redirect:/schedule/list.do";
    }

    /**
     * 暂停任务
     */
    @RequestMapping("/{name}/stop.do")
    public String stop(@PathVariable String name, RedirectAttributes attr) {
        String message = SUCCESS_MESSAGE;
        try {
            scheduleJobService.stopJob(name, TASK_GROUP);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            message = ERROR_MESSAGE;
        }

        attr.addFlashAttribute("message", message);

        return "redirect:/schedule/list.do";
    }

    /**
     * 删除任务
     */
    @RequestMapping("/{name}/delete.do")
    public String delete(@PathVariable String name, RedirectAttributes attr) {
        String message = SUCCESS_MESSAGE;
        try {
            scheduleJobService.delJob(name, TASK_GROUP);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            message = ERROR_MESSAGE;
        }

        attr.addFlashAttribute("message", message);

        return "redirect:/schedule/list.do";
    }

    @RequestMapping("/edit.do")
    public String edit(@RequestParam String name, @RequestParam String cronExpression, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("cronExpression", cronExpression);
        return "schedule/jobEdit";
    }

    /**
     * 修改表达式
     */
    @RequestMapping("/update.do")
    public String update(@RequestParam String name, @RequestParam String cronExpression, RedirectAttributes attr) {
        String message = SUCCESS_MESSAGE;
        //验证cron表达式
        if (CronExpression.isValidExpression(cronExpression)) {
            scheduleJobService.modifyTrigger(name, TASK_GROUP, cronExpression);
        } else {
            message = "Cron表达式不正确";
        }
        attr.addFlashAttribute("message", message);

        return "redirect:/schedule/list.do";
    }

    /**
     * 立即运行一次
     */
    @RequestMapping("/{name}/runNow.do")
    @ResponseBody
    public String runNow(@PathVariable String name) {
        String message = SUCCESS_MESSAGE;
        try {
            scheduleJobService.startNowJob(name, TASK_GROUP);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            message = ERROR_MESSAGE;
        }

        return message;
    }

    /**
     * 恢复
     */
    @RequestMapping("/{name}/resume.do")
    public String resume(@PathVariable String name, RedirectAttributes attr) {
        String message = SUCCESS_MESSAGE;
        try {
            scheduleJobService.restartJob(name, TASK_GROUP);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            message = ERROR_MESSAGE;
        }

        attr.addFlashAttribute("message", message);

        return "redirect:/schedule/list.do";
    }

    /**
     * 获取所有trigger
     */
    public void getTriggers(HttpServletRequest request) {
        List<ScheduleJob> scheduleJobs = scheduleJobService.getTriggersInfo();
        System.out.println(scheduleJobs.size());
        request.setAttribute("triggers", scheduleJobs);
    }
}
